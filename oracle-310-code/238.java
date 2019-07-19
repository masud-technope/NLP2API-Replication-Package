package org.kodejava.example.text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateToString {
    public static void main(String[] args) {
        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date (day/month/year)
        String pattern = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(pattern);

        // Get the date today using Calendar object.
        Date today = Calendar.getInstance().getTime();

        // Using DateFormat format method we can create a string
        // representation of a date with the defined format.
        String reportDate = df.format(today);

        // Print what date is today!
        System.out.println("Report Date: " + reportDate);

        // Using Java 8.
        // Creates a DateTimeFormatter using the ofPattern() method. Get
        // the current date by calling the .now() method of LocalDate.
        // To convert to string use the format() method of the LocalDate
        // and pass the formatter object as argument.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate now = LocalDate.now();
        reportDate = now.format(formatter);
        System.out.println("Report Date: " + reportDate);
    }
}
