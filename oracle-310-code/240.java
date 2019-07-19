package org.kodejava.example.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpResponseHeaderDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.kodejava.org/index.html");
            URLConnection connection = url.openConnection();

            Map responseMap = connection.getHeaderFields();
            for (Iterator iterator = responseMap.keySet().iterator(); iterator.hasNext();) {
                String key = (String) iterator.next();
                System.out.print(key + " = ");

                List values = (List) responseMap.get(key);
                for (int i = 0; i < values.size(); i++) {
                    Object o = values.get(i);
                    System.out.print(o + ", ");
                }
                System.out.println("");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
