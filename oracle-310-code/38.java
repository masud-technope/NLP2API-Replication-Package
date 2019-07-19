package org.kodejava.example.util;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Date;

public class DateFormatSymbolsExample {
    public static void main(String[] args) {
        //
        // Defining a new Date Format Symbols, the following are month and day names in Indonesian.
        //
        String[] newMonths = {"JANUARI", "FEBRUARI", "MARET", "APRIL", "MEI", "JUNI",
                "JULI", "AGUSTUS", "SEPTEMBER", "OKTOBER", "NOVEMBER", "DESEMBER"};
        String[] newShortMonths = {"JAN", "FEB", "MAR", "APR", "MEI", "JUN",
                "JUL", "AGU", "SEP", "OKT", "NOV", "DES"};
        String[] newWeekdays = {"", "MINGGU", "SENIN", "SELASA", "RABU", "KAMIS", "JUMAT", "SABTU"};
        String[] shortWeekdays = {"", "MIN", "SEN", "SEL", "RAB", "KAM", "JUM", "SAB"};

        DateFormatSymbols symbols = new DateFormatSymbols();
        symbols.setMonths(newMonths);
        symbols.setShortMonths(newShortMonths);
        symbols.setWeekdays(newWeekdays);
        symbols.setShortWeekdays(shortWeekdays);

        DateFormat format = new SimpleDateFormat("dd MMMM yyyy", symbols);
        System.out.println(format.format(new Date()));
        
        format = new SimpleDateFormat("dd MMM yyyy", symbols);
        System.out.println(format.format(new Date()));

        format = new SimpleDateFormat("EEEE, dd MMM yyyy", symbols);
        System.out.println(format.format(new Date()));

        format = new SimpleDateFormat("E, dd MMM yyyy", symbols);
        System.out.println(format.format(new Date()));
    }
}