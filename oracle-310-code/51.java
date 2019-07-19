package org.kodejava.example.text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class NumberFormatSymbol {
    public static void main(String[] args) {
        DecimalFormat formatter;
        String pattern = "###,###.##";
        double number = 123456.789;

        //
        // Create a DecimalFormatSymbols object for United States
        // locale.
        //
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(Locale.US);

        //
        // Create a format object with the given pattern without
        // change the locale dfs then format the given value.
        //
        formatter = new DecimalFormat(pattern);
        String before = formatter.format(number);

        //
        // Change the decimal separator and grouping separator symbol.
        //
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        dfs.setMinusSign('-');
        dfs.setPercent('%');

        //
        // Create a format object with the given pattern and symbol
        // then format the given value.
        //
        formatter = new DecimalFormat(pattern, dfs);
        String after = formatter.format(number);

        System.out.println("before: " + before + " | after: " + after);
    }
}