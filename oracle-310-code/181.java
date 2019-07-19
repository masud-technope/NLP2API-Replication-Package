package org.kodejava.example.text;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class MonthNames {
    public static void main(String[] args) {
        String[] months = new DateFormatSymbols().getMonths();
        for (String month : months) {
            System.out.println("month = " + month);
        }

        String[] shortMonths = new DateFormatSymbols().getShortMonths();
        for (String shortMonth : shortMonths) {
            System.out.println("shortMonth = " + shortMonth);
        }

        DateFormatSymbols dfs = new DateFormatSymbols(Locale.GERMANY);
        String[] germanyMonths = dfs.getMonths();
        for (String germanyMonth : germanyMonths) {
            System.out.println("germanyMonth = " + germanyMonth);
        }

        String[] germanyShortMonths = dfs.getShortMonths();
        for (String germanyShortMonth : germanyShortMonths) {
            System.out.println("germanyShortMonth = "
                    + germanyShortMonth);
        }
    }
}
