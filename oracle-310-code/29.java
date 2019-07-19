package org.kodejava.example.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class EntityAsString {
    public static void main(String[] args) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://kodejava.org");

        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();

            // Read the contents of an entity and return it as a String.
            String content = EntityUtils.toString(entity);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}