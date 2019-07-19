package org.kodejava.example.text;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatChangeLocalePattern {
    public static void main(String[] args) {
        String pattern = "dd-MMM-yyyy";
        Date today = new Date();

        //
        // Gets a formatted date according to the given pattern.
        // Here only the pattern is passed as argument of the
        // SimpleDateFormat constructor, so it will format the
        // date according to the default Locale.
        //
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String local = sdf.format(today);
        System.out.println("Date in default locale: " + local);

        Locale[] locales = {
                Locale.CANADA,
                Locale.FRANCE,
                Locale.GERMANY,
                Locale.US,
                Locale.JAPAN
        };

        for (Locale locale : locales) {
            //
            // Format a date according to the given pattern for each
            // locale.
            //
            sdf = new SimpleDateFormat(pattern, locale);
            String after = sdf.format(today);
            System.out.println(locale.getDisplayCountry() + 
                    " | format: " + after);
        }
    }
}
