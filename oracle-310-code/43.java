package org.kodejava.example.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MacAddress {
    public static void main(String[] args) {
        try {
            //InetAddress address = InetAddress.getLocalHost();
            InetAddress address = InetAddress.getByName("192.168.46.53");

            /*
             * Get NetworkInterface for the current host and then read
             * the hardware address.
             */
            NetworkInterface ni = 
                    NetworkInterface.getByInetAddress(address);
            if (ni != null) {
                byte[] mac = ni.getHardwareAddress();
                if (mac != null) {
                    /*
                     * Extract each array of mac address and convert it 
                     * to hexa with the following format 
                     * 08-00-27-DC-4A-9E.
                     */
                    for (int i = 0; i < mac.length; i++) {
                        System.out.format("%02X%s",
                                mac[i], (i < mac.length - 1) ? "-" : "");
                    }
                } else {
                    System.out.println("Address doesn't exist or is not " +
                            "accessible.");
                }
            } else {
                System.out.println("Network Interface for the specified " +
                        "address is not found.");
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}