package org.kodejava.example.text;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class LocaleDateTime {
    public static void main(String[] args) {
        Locale[] locales = {
                Locale.CANADA,
                Locale.FRANCE,
                Locale.GERMANY,
                Locale.US,
                Locale.JAPAN
        };
        Date today = new Date();

        for (Locale locale : locales) {
            StringBuilder sb = new StringBuilder();
            sb.append(locale.getDisplayCountry());
            sb.append("n--------------------------------");

            //
            // Gets a DateFormat instance for the specified locale
            // and format a date object by calling the format
            // method.
            //
            DateFormat df = DateFormat.getDateInstance(
                    DateFormat.DEFAULT, locale);
            String date = df.format(today);
            sb.append("n Default date format: ").append(date);

            //
            // Gets a DateFormat instance for the specified locale
            // and format a time information by calling the format
            // method.
            //
            DateFormat tf = DateFormat.getTimeInstance(
                    DateFormat.DEFAULT, locale);
            String time = tf.format(today.getTime());
            sb.append("n Default time format: ").append(time)
                    .append("n");

            System.out.println(sb.toString());
        }

        //
        // Gets date and time formatted value for Italy locale using
        // To display a date and time in the same String, create the
        // formatter with the getDateTimeInstance method.
        // The first parameter is the date style, and the second is
        // the time style. The third parameter is the Locale
        //
        DateFormat dtf = DateFormat.getDateTimeInstance(
                DateFormat.DEFAULT, DateFormat.DEFAULT,
                Locale.ITALY);
        String datetime = dtf.format(today);

        System.out.println("date time format in " +
                Locale.ITALY.getDisplayCountry() + ": " + datetime);
    }
}
