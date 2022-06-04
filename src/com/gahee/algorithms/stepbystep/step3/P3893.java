package com.gahee.algorithms.stepbystep.step3;

import java.util.Scanner;

public class P3893 {
    public static void main(String[] args) {
        // n 이 주어졌을 때 1부터 엔까지의 합을 구하라
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            result += i;
        }
        System.out.println(result);
    }
}
