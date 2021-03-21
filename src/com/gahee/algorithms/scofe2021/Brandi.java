package com.gahee.algorithms.scofe2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// 최대한 많은 옷 구매하기
public class Brandi {

    public static void main(String[] args) throws IOException {
        // N M
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        int [][] h = new int[M][N];

        for (int i = 0; i < M; i++) {
            String [] tmp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                h[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        System.out.println(Arrays.deepToString(h));

        // 그리디
        int [][] g = new int[M + 1][N + 1];

        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if(i == 1 && j == 1){
                    g[i][j] = h[i-1][j-1];
                }else if(i == 1){
                    g[i][j] = h[i-1][j-2] + h[i-1][j-1];
                }else if(j == 1){
                    g[i][j] = h[i-2][j-1] + h[i-1][j-1];
                }else{
                    g[i][j] = Integer.max(g[i-1][j], g[i][j-1]) + h[i-1][j-1];
                }
            }
        }

        System.out.println(Arrays.deepToString(g));

        System.out.println("answer = " + g[M][N]);
    }
}
