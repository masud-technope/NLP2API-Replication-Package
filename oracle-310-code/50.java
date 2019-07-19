package org.kodejava.example.text;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ChangeDateFormatSymbols {
    public static void main(String[] args) {
        Locale id = new Locale("in", "ID");
        String pattern = "EEEE, dd MMM yyyy";
        Date today = new Date();

        //
        // Gets formatted date specify by the given pattern for
        // Indonesian Locale no changes for default date format
        // is applied here.
        //
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, id);
        String before = sdf.format(today);
        System.out.println("Before format change: " + before);

        //
        // Create a DateFormatSymbols object for Indonesian locale.
        //
        DateFormatSymbols dfs = new DateFormatSymbols(id);

        //
        // Gets String array of default format of weekdays.
        //
        String[] days = dfs.getWeekdays();
        String newDays[] = new String[days.length];
        for (int i = 0; i < days.length; i++) {
            //
            // For each day, apply toUpperCase() method to
            // capitalized it.
            //
            newDays[i] = days[i].toUpperCase();
        }

        //
        // Set String array of weekdays.
        //
        dfs.setWeekdays(newDays);

        //
        // Gets String array of default format of short months.
        //
        String[] shortMonths = dfs.getShortMonths();
        String months[] = new String[shortMonths.length];
        for (int j = 0; j < shortMonths.length; j++) {
            //
            // For each short month, apply toUpperCase() method
            // to capitalized it.
            //
            months[j] = shortMonths[j].toUpperCase();
        }

        //
        // Set String array of short months.
        //
        dfs.setShortMonths(months);

        //
        // Create a SimpleDateFormat object by given pattern and 
        // symbol and then format the date object as String.
        //
        sdf = new SimpleDateFormat(pattern, dfs);
        String after = sdf.format(today);
        System.out.println("After change format : " + after);
    }
}