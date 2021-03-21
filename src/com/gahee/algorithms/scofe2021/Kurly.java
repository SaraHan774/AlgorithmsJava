package com.gahee.algorithms.scofe2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Kurly {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int N = Integer.parseInt(input);
        int [] dp = new int[N];
        dp[0] = 1;

        String p = br.readLine();

        for (int i = 1; i < N; i++) {
            char a = p.charAt(i);

            if(i == 1){
                if(a == '0'){
                    dp[i] = 0;
                }else{
                    dp[i] = 1;
                }
            }

            if(i >= 2) {
                if (a == '0') {
                    dp[i] = 0;
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
        }

        System.out.println(dp[N-1]);
    }
}
