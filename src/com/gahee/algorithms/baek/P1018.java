package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char [][] chessBoard = new char[M][N];

        for (int i = 0; i < M; i++) {
            String string = br.readLine();
            char [] s = string.toCharArray();
            for (int j = 0; j < N; j++) {
                chessBoard[i][j] = s[j];
//                System.out.print(s[j]);
            }
//            System.out.println();
        }



        br.close();
    }

}
