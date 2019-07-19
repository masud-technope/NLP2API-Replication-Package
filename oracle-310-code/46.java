package org.kodejava.example.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            String ip = address.getHostAddress();

            System.out.println("IP Address = " + ip);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}