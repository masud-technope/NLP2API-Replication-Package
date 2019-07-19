package org.kodejava.example.text;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleCurrencyFormat {
    public static void main(String[] args) {
        Double number = 1500D;

        // Format currency for Canada locale in Canada locale, 
        // the decimal point symbol is a comma and currency
        // symbol is $.
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CANADA);
        String currency = format.format(number);
        System.out.println("Currency in Canada : " + currency);

        // Format currency for Germany locale in German locale,
        // the decimal point symbol is a dot and currency symbol
        // is €.
        format = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        currency = format.format(number);
        System.out.println("Currency in Germany: " + currency);
    }
}
