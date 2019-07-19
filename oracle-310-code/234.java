package org.kodejava.example.text;

import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.text.MessageFormat;

public class MessageFormatTime {
    public static void main(String[] args) {
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 7);

        Date nextWeek = calendar.getTime();

        // We want the message to be is Locale.US
        Locale.setDefault(Locale.US);

        // Format a time including date information.
        String message = MessageFormat.format("Now is {0} and the next " +
                "7 hours is {1}", today, nextWeek);
        System.out.println(message);

        // Format a time and display only the time portion
        message = MessageFormat.format("Now is {0, time} and the next " +
                "7 hours is {1, time}", today, nextWeek);
        System.out.println(message);

        // Format a time using a short format (eg. HH:mm am/pm)
        message = MessageFormat.format("Now is {0, time, short} and " +
                "the next 7 hours is {1, time, short}", today, nextWeek);
        System.out.println(message);

        // Format a time using a medium format (eg. HH:mm:ss am/pm).
        message = MessageFormat.format("Now is {0, time, medium} and " +
                "the next 7 hours is {1, time, medium}", today, nextWeek);
        System.out.println(message);

        // Format a time using a long format (eg. HH:mm:ss am/pm TIMEZONE).
        message = MessageFormat.format("Now is {0, time, long} and the " +
                "next 7 hours is {1, time, long}", today, nextWeek);
        System.out.println(message);

        // Format a time using a full format (eg. HH:mm:ss am/pm TIMEZONE).
        message = MessageFormat.format("Now is {0, time, full} and the " +
                "next 7 hours is {1, time, full}", today, nextWeek);
        System.out.println(message);

        // Format a time using a custom pattern.
        message = MessageFormat.format("Now is {0, time, HH:mm:ss.sss} " +
                "and the next 7 hours is {1, time, HH:mm:ss.sss}", today, nextWeek);
        System.out.println(message);
    }
}
