package com.gahee.algorithms.kickstart2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KGoodnessString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int T = Integer.parseInt(input);

        for (int i = 0; i < T; i++) {
            String [] a = br.readLine().split(" ");
            int N = Integer.parseInt(a[0]);
            int K = Integer.parseInt(a[1]);
            String s = br.readLine();
            computeAnswer(i + 1, N, K, s);
        }
    }

    private static void computeAnswer(int numT, int n, int k, String s) {
        int answer;
        int i = 0;
        int j = n - 1;
        int gs = 0;
        while(i < j){
            if(s.charAt(i++) != s.charAt(j--)){
                gs++;
            }
        }
        answer = Math.abs(gs - k);
        System.out.println("Case #" + numT+ ": " + answer);
    }

    private static void googleAnswer(int numT, int n, int k, String s){
        int minOperations;
        int x = 0;

        for (int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1)){
                x++;
            }
        }

        if(x == k){
            minOperations = 0;
        }else if(x > k){
            minOperations = x - k;
        }else{
            minOperations = k - x;
        }

        System.out.println(minOperations);
    }
}
