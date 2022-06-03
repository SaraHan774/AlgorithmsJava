package com.gahee.algorithms.stepbystep.step2;

import java.util.Scanner;

public class P2884 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int h = s.nextInt();
        int m = s.nextInt();

        int m2 = m - 45;
        int h2 = h;
        if (m2 < 0) {
            h2 = h - 1;
            if (h2 < 0) {
                h2 = 23;
            }
            m2 += 60;
        }
        System.out.println(h2 + " " + m2);
    }
}
