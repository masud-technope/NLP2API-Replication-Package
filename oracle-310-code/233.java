package org.kodejava.example.text;

import java.text.MessageFormat;
import java.util.Locale;

public class MessageFormatNumber {
    public static void main(String[] args) {

        // Set the Locale for the MessageFormat.
        Locale.setDefault(Locale.US);

        // Use the default formatting for number.
        String message = MessageFormat.format("This is a {0} and {1} numbers",
                10, 75);
        System.out.println(message);

        // This line have the same format as above.
        message = MessageFormat.format("This is a {0,number} and {1,number} " +
                "numbers", 10, 75);
        System.out.println(message);

        // Format a number with 2 decimal digits.
        message = MessageFormat.format("This is a formatted {0, number,#.##} " +
                "and {1, number,#.##} numbers", 25.7575, 75.2525);
        System.out.println(message);

        // Format a number as currency.
        message = MessageFormat.format("This is a formatted currency " +
                "{0,number,currency} and {1,number,currency} numbers",
                25.7575, 25.7575);
        System.out.println(message);

        // Format numbers in percentage.
        message = MessageFormat.format("This is a formatted percentage " +
                "{0,number,percent} and {1,number,percent} numbers", 0.10, 0.75);
        System.out.println(message);
    }
}
