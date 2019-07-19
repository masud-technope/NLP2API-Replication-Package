package org.kodejava.example.text;

import java.text.DateFormatSymbols;

public class WeekdayNames {
    public static void main(String[] args) {
        DateFormatSymbols dfs = new DateFormatSymbols();

        String[] weekdays = dfs.getWeekdays();
        for (String weekday : weekdays) {
            System.out.println("weekday = " + weekday);
        }

        String[] shortWeekdays = dfs.getShortWeekdays();
        for (String shortWeekday : shortWeekdays) {
            System.out.println("shortWeekday = " + shortWeekday);
        }
    }
}
