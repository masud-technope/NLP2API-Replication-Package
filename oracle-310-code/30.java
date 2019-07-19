package org.kodejava.example.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.nio.charset.Charset;

public class EntityContentType {
    public static void main(String[] args) {
        EntityContentType demo = new EntityContentType();
        demo.getContentType("http://www.google.com");
        demo.getContentType("http://www.google.com/images/srpr/logo3w.png");
    }

    public void getContentType(String url) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            showContentType(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showContentType(HttpEntity entity) {
        ContentType contentType = ContentType.getOrDefault(entity);
        String mimeType = contentType.getMimeType();
        Charset charset = contentType.getCharset();

        System.out.println("MimeType = " + mimeType);
        System.out.println("Charset  = " + charset);
    }
}

