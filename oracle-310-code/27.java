package org.kodejava.example.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayReverse {
    public static void main(String[] args) {
        //
        // Creates an array of Integers and print it out.
        //
        Integer[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Arrays.toString(numbers) = " +
                Arrays.toString(numbers));

        //
        // Convert the int arrays into a List.
        //
        List numberList = Arrays.asList(numbers);

        //
        // Reverse the order of the List.
        //
        Collections.reverse(numberList);

        //
        // Convert the List back to arrays of Integers
        // and print it out.
        //
        numberList.toArray(numbers);
        System.out.println("Arrays.toString(numbers) = " +
                Arrays.toString(numbers));
    }
}