package com.gahee.algorithms.programmers;

import java.util.Arrays;

public class StockPrice1 {

    public static void main(String[] args) {
        int [] prices = {3, 5, 1, 2, 6, 2, 7, 2, 1};
        int [] ans = solution(prices);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solution(int[] prices) {
        int[] answer;
        answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int cur = prices[i];

            for (int j = i; j < prices.length; j++) {
                if(j == prices.length - 1){
                    answer[j] = 0;
                    break;
                }
                if(cur <= prices[j]){
                    answer[i]++;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
}
