package com.gahee.algorithms.inflearn.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        //dp - 답을 알고, 그 전단계를 파는 것 ?
        //1, 2, 5
        //11 - 10, 9, 6
        //1, 2, 5 라는 숫자를 갖고 11이라는 숫자를 만드는 것
        int [] coins = {1, 2, 5};
        int amout = 11;
        System.out.println(coinChange(coins, amout));
    }

    private static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int [] dp = new int[max];

        //dp 에다가 12을 채워준다.
        Arrays.fill(dp, max);
        dp[0] = 0; //0번은 0을 넣어준다.

        //데이터를 불러오기
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
