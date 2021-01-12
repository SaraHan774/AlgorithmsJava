package com.gahee.algorithms.inflearn.dp;

import java.util.Arrays;

public class ClimbStairs {

    public static void main(String[] args) {
        int n = 40;
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        int [] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        int answer = 0;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        answer = dp[n];
        System.out.println(Arrays.toString(dp));
        return answer;
    }
}
