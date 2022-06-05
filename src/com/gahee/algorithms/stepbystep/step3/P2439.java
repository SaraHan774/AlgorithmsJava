package com.gahee.algorithms.stepbystep.step3;

import java.util.Scanner;

public class P2439 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j < n - i - 1) {
                    sb.append(" ");
                } else {
                    sb.append("*");
                }
            }
            System.out.println(sb);
        }
    }
}
