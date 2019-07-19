package org.kodejava.example.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) {
        try {
            //
            // Creating a url object by specifing each parameter separately, including
            // the protocol, hostname, port number, and the page name
            //
            URL url = new URL("http", "www.kodejava.org", 80, "/index.html");

            //
            // We can also specify the address in a single line
            //
            url = new URL("http://www.kodejava.org:80/index.html");

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
