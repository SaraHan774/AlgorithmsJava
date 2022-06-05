package com.gahee.algorithms.stepbystep.step3;

import java.util.Scanner;

public class P2438 {

    public static void main(String[] args) {
        // stars
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }
}
