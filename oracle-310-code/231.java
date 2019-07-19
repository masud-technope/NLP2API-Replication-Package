package org.kodejava.example.text;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatSymbols {
    public static void main(String[] args) {
        double number = 123456.789;

        Locale[] locales = {
                Locale.CANADA,
                Locale.GERMANY,
                Locale.UK,
                Locale.ITALY,
                Locale.US
        };

        String[] symbols = { "CAD", "EUR", "GBP", "ITL", "USD"};

        for (int i = 0; i < locales.length; i++) {
            //
            // Gets currency's formatted value for each locale
            // without change the currency symbol
            //
            DecimalFormat formatter = (DecimalFormat) 
                    NumberFormat.getCurrencyInstance(locales[i]);
            String before = formatter.format(number);

            //
            // Create a DecimalFormatSymbols for each locale and sets
            // its new currency symbol.
            //
            DecimalFormatSymbols symbol = 
                    new DecimalFormatSymbols(locales[i]);
            symbol.setCurrencySymbol(symbols[i]);

            //
            // Set the new DecimalFormatSymbols into formatter object.
            //
            formatter.setDecimalFormatSymbols(symbol);

            //
            // Gets the formatted value
            //
            String after = formatter.format(number);

            System.out.println(locales[i].getDisplayCountry() + 
                    " | before: " + before + " | after: " + after);
        }
    }
}
