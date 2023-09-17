package com.gahee.algorithms.stepbystep.step7;

import java.util.Scanner;

public class P1193 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0;
        System.out.println(i);

        while(n > (i * (i - 1))) {
            i++;
        }
        // 그룹 안에서 몇번째

        System.out.println(i);
        System.out.println(n - (i - 1) * (i - 2));
    }
}
