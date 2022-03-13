package com.gahee.algorithms.leetcode;

import java.util.Random;

public class Tribonacci {

    public static void main(String[] args) {
        Prob b = new Prob();
        for (int i = 0; i < 100; i++) {
            int random = new Random().nextInt(38);
            int result = b.tribonacci(random);
            System.out.println("random int  = " + random + " / " + result);
        }
    }

    static class Prob {
        public int[] arr = new int[38];

        public Prob() {
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 1;
        }
        // 배열에 저장하지 않으면 속도가 나지 않음.
        public int tribonacci(int n) {
            if (n == 0) return arr[0];
            if (n == 1) return arr[1];
            if (n == 2) return arr[2];

            if (arr[n] != 0) {
                return arr[n];
            } else {
                int tri = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
                arr[n] = tri;
                return tri;
            }
        }
    }
}
