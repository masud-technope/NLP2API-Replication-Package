package org.kodejava.example.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HttpPostExample {
    public static void main(String[] args) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("http://localhost:8080/register");

        // Create some NameValuePair for HttpPost parameters
        List<NameValuePair> arguments = new ArrayList<>(3);
        arguments.add(new BasicNameValuePair("username", "admin"));
        arguments.add(new BasicNameValuePair("firstName", "System"));
        arguments.add(new BasicNameValuePair("lastName", "Administrator"));

        try {
            post.setEntity(new UrlEncodedFormEntity(arguments));
            HttpResponse response = client.execute(post);

            // Print out the response message
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}