package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11720 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String M = br.readLine();

        char [] numbers = M.toCharArray();

        int answer = 0, K;
        for (int i = 0; i < N; i++) {
            K = (int)numbers[i] - 48;
            answer += K;
        }
        System.out.println(answer);
        br.close();
    }
}
