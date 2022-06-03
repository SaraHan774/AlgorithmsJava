package com.gahee.algorithms.stepbystep.step2;

import java.util.Scanner;

public class P2753 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        if (a < 1  || a > 4000) {
            throw new IllegalStateException();
        }

        if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
