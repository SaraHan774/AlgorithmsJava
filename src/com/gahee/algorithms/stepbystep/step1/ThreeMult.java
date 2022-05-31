package com.gahee.algorithms.stepbystep.step1;

import java.util.Scanner;

public class ThreeMult {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();

        char[] arrB = String.valueOf(b).toCharArray();

        int result = 0;
        int m;

        for (int j = 2; j >= 0; j--) {
            m = Character.getNumericValue(arrB[j]);
            result = result + (a * m) * (int) Math.pow(10, (2 - j));
            System.out.println(a * m);
        }

        System.out.println(result);
    }
}
