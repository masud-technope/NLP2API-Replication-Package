package org.kodejava.example.text;

import java.util.Locale;
import java.text.NumberFormat;
import java.text.ParseException;

public class LocaleNumberParse {
    public static void main(String[] args) {
        try {
            // In this example we are trying to parse a number string in a
            // defined format. Basically we want to covert the string for a
            // locale into a correct number value.
            Number number =
                NumberFormat.getNumberInstance(Locale.JAPAN).parse("25,000.75");

            // Just do some stuff with the number from the parse process
            if (number instanceof Long) {
                System.out.println("This number is instanceof Long and the " +
                    "value is: " + number.longValue());
            } else if (number instanceof Double) {
                System.out.println("This number is instanceof Double and the " +
                    "value is: " + number.doubleValue());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}