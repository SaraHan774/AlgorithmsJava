package com.gahee.algorithms.stepbystep.step4;

import java.util.Scanner;

public class P2577 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int [] arr = new int[10];
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        int mul = a * b * c;
        char [] chars = String.valueOf(mul).toCharArray();
        for (char aChar : chars) {
            int k = Character.getNumericValue(aChar);
            arr[k]++;
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
