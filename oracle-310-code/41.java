package org.kodejava.example.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class RawIPToString {
    public static void main(String[] args) {
        InetAddress address = null;

        byte[] ip = new byte[0];
        try {
            address = InetAddress.getLocalHost();
            ip = address.getAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        String ipAddress = RawIPToString.getIpAddress(ip);
        System.out.println("IP Address = " + ipAddress);

        try {
            address = InetAddress.getByName("google.com");
            ip = address.getAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        ipAddress = RawIPToString.getIpAddress(ip);
        System.out.println("IP Address = " + ipAddress);
    }

    /**
     * Convert raw IP address to string.
     *
     * @param rawBytes raw IP address.
     * @return a string representation of the raw ip address.
     */
    public static String getIpAddress(byte[] rawBytes) {
        int i = 4;
        String ipAddress = "";
        for (byte raw : rawBytes)
        {
            ipAddress += (raw & 0xFF);
            if (--i > 0)
            {
                ipAddress += ".";
            }
        }

        return ipAddress;
    }
}