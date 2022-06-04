package com.gahee.algorithms.stepbystep.step3;

import java.util.Scanner;

public class P2739 {

    public static void main(String[] args) {
        // N 을 입력 받은 뒤 구구단 출력
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < 9; i++) {
            System.out.println(n + " * " + (i + 1) + " = " + n * (i+1));
        }
    }
}
