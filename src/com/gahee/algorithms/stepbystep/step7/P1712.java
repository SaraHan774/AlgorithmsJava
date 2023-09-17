package com.gahee.algorithms.stepbystep.step7;

import java.util.Scanner;

public class P1712 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        if (c == 0) { // free sell
            System.out.println(-1);
            return;
        }

        if (b == 0) { // no cost
            System.out.println(1);
            return;
        }

        if ((double) b / c > 1) {
            System.out.println(-1);
        } else if (b / c == 1) {
            int n = a / b;
            System.out.println(n);
        } else {
            // TODO : come back later
            int k = c - b; // profit
            int n = a / k;
            System.out.println(n + 1);
        }
    }
}
