package com.gahee.algorithms.stepbystep.step4;

import java.util.Scanner;

public class P3052 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] arr = new int[42];

        for (int i = 0; i < 10; i++) {
            int k = scanner.nextInt();
            if (k < 42) {
                arr[k]++;
            } else {
                int r = k % 42;
                arr[r]++;
            }
        }

        int result = 0;
        for (int i : arr) {
            if (i != 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
