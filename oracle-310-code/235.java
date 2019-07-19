package org.kodejava.example.text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class DateValidation {
    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        // Input to be parsed should strictly follow the defined date format
        // above.
        format.setLenient(false);

        String date = "29/18/2017";
        try {
            format.parse(date);
        } catch (ParseException e) {
            System.out.println("Date " + date + " is not valid according to " +
                ((SimpleDateFormat) format).toPattern() + " pattern.");
        }
    }
}
