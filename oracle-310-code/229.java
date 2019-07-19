package org.kodejava.example.text;

import java.text.BreakIterator;
import java.util.Locale;

public class BreakIteratorExample {
    public static void main(String[] args) {
        String data = "The quick brown fox jumps over the lazy dog.";
        String search = "dog";

        //
        // Gets an instance of BreakIterator for word break for the
        // given locale. We can instantiate a BreakIterator without
        // specifying the locale. The locale is important when we
        // are working with languages like Japanese or Chinese where
        // the breaks standard may be different compared to English.
        //
        BreakIterator bi = BreakIterator.getWordInstance(Locale.US);

        //
        // Set the text string to be scanned.
        //
        bi.setText(data);

        //
        // Iterates the boundary / breaks
        //
        System.out.println("Iterates each word: ");
        int count = 0;
        int lastIndex = bi.first();
        while (lastIndex != BreakIterator.DONE) {
            int firstIndex = lastIndex;
            lastIndex = bi.next();

            if (lastIndex != BreakIterator.DONE
                    && Character.isLetterOrDigit(
                    data.charAt(firstIndex))) {
                String word = data.substring(firstIndex, lastIndex);
                System.out.println("'" + word + "' found at (" +
                        firstIndex + ", " + lastIndex + ")");

                //
                // Counts how many times the word dog occurs.
                //
                if (word.equalsIgnoreCase(search)) {
                    count++;
                }
            }
        }

        System.out.println("");
        System.out.println("Number of word '" + search +
                "' found = " + count);
    }
}
