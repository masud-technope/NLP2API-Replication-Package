package org.kodejava.example.text;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class IterateSubstringExample {
    private static final String text =
        "How razorback-jumping frogs can level six piqued gymnasts";

    public static void main(String[] args) {
        CharacterIterator it = new StringCharacterIterator(text, 4, 27, 5);

        // In this loop we just iterator a subset of charater defined in the
        // StringCharacterIterator above. It reads from the 4 index of the
        // string up to the 27 character. So it will just take the following
        // string "razorback-jumping frogs"
        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
            System.out.print(ch);
        }
    }
}