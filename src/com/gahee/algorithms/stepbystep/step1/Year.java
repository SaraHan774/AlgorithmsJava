package com.gahee.algorithms.stepbystep.step1;

import java.util.Scanner;

public class Year {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        int n = s.nextInt(); // 불교연도
        int diff = 2541 - 1998;
        System.out.println(n - diff);
    }
}
