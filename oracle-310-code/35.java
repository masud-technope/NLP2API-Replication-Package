package org.kodejava.example.util;

import java.util.TimeZone;

public class HostDefaultTimezone {
    public static void main(String[] args) {
        // 
        // Gets the default TimeZone ID for this host
        //
        String id = TimeZone.getDefault().getID();
        System.out.println("nDefault Time Zone ID: " + id);
    }
}