package com.gahee.algorithms.stepbystep.step5;

import java.util.Arrays;
import java.util.Scanner;

public class P1065 {

    public static void main(String[] args) {
        // 각 자리수가 등차수열을 이루는 수를 '한수'라고 한다.
        // 숫자 N 이 주어졌을 때 1이상, N이하의 한수의 개수를 출력하라.

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int result = 0;
        for (int i = 1; i <= N; i++) {
            String n = String.valueOf(i);
            char [] chars = n.toCharArray();
            int [] ints = new int[n.length()];
            for (int i1 = 0; i1 < chars.length; i1++) {
                int k = Character.getNumericValue(chars[i1]);
                ints[i1] = k;
            }
            System.out.println(Arrays.toString(ints));
            if (checkNum(ints)) {
                result++;
            }
        }

        System.out.println(result);
    }

    private static boolean checkNum(int[] ints) {
        if (ints.length < 2) return true;
        int i = 1;
        int sub = ints[0] - ints[1];

        while(i < ints.length - 1) {
            int p = ints[i];
            int q = ints[i + 1];
            if (sub != p - q) {
                return false;
            }
            i++;
        }
        return i == ints.length - 1;
    }
}
