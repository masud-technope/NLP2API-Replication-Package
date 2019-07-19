package org.kodejava.example.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ComparingDate {
    public static void main(String[] args) {
        //
        // Create a SimpleDateFormat instance with dd/MM/yyyy format
        //
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        //
        // Get the current date
        //
        Date today = new Date();
        
        //
        // Create an instance of calendar that represing a new year date
        //
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.YEAR, 2009);

        String now = df.format(today);
        String newYear = df.format(calendar.getTime());

        //
        // Using the string equals method we can compare the date.
        //
        if (now.equals(newYear)) {
            System.out.println("Happy New Year!");
        } else {
            System.out.println("Have a nive day!");
        }
    }
}