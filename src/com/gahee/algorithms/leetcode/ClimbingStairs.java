package com.gahee.algorithms.leetcode;

public class ClimbingStairs {

    public static void main(String[] args) {

    }

    private static class Solution {
        // 1 <= n <= 45
        int [] arr = new int[46];

        // [][], [][][], [][] + [][], [][][] + [][] or [][] + [][][],
        public int climbStairs(int n) {
            // step 1, 2 - in how many distinct ways can you climb to the top ?
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 3;
            arr[4] = 5;

            // 1 (1)
            // 2 (1, 1) (2)
            // 3 (1, 1, 1) (1, 2) (2, 1)
            // 4 (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (2, 1, 1) (2, 2)
            // 5 (1, 1, 1, 1, 1) (1, 1, 1, 2) (1, 1, 2, 1) (1, 2, 1, 1) (2, 1, 1, 1)
            // (2, 2, 1) (2, 1, 2) (1, 2, 2)

            // 6 (1, 1, 1, 1, 1, 1) ...

            return 0;
        }
    }
}
