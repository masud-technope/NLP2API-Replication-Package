package org.kodejava.example.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class DateTimeParseDemo {
    public static void main(String[] args) {

        // Parse string "2014-09-12" into LocalDate instance.
        LocalDate date = LocalDate.parse("2014-09-12");

        // Parse string "17:51:15: into LocalTime instance.
        LocalTime time = LocalTime.parse("17:51:15");

        // Parse string "2014-09-12T17:51:15" into LocalDateTime instance.
        LocalDateTime dateTime = LocalDateTime.parse("2014-09-12T17:51:15");

        System.out.println("date     = " + date);
        System.out.println("time     = " + time);
        System.out.println("dateTime = " + dateTime);

        try {
            // When the string cannot be parse a RuntimeException of type
            // DateTimeParseException will be thrown.
            LocalDate date1 = LocalDate.parse("2014-02-31");
            System.out.println("date1     = " + date1);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
    }
}