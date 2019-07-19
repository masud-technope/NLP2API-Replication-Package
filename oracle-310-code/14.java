package org.kodejava.example.commons.lang;

import org.apache.commons.lang.ArrayUtils;

public class PrimitiveArrayClone {
    public static void main(String[] args) {
        int[] fibonacci = new int[] {1, 1, 2, 3, 5, 8, 13, 21, 34, 55};
        System.out.println("fibonacci = " + ArrayUtils.toString(fibonacci));

        int[] clone = ArrayUtils.clone(fibonacci);
        System.out.println("clone = " + ArrayUtils.toString(clone));
    }
}