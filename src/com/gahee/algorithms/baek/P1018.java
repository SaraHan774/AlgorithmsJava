package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {

    static int firstB = 0;
    static int firstW = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] chessBoard = new char[N][M];

        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            char[] s = string.toCharArray();
            for (int j = 0; j < M; j++) {
                chessBoard[i][j] = s[j];
                //System.out.print(s[j]);
            }
            //System.out.println();
        }

        int minChange = Integer.MAX_VALUE;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                //체스보드를 8*8 로 쪼갠다
                //다시 0으로 초기화한다.
                firstB = 0;
                firstW = 0;
                for (int k = i; k < 8 + i; k++) { //K 행
                    for (int l = j; l < 8 + j; l++) { //L 열
                        //다시 칠해야 하는 부분을 알아낸다.
                        // B 먼저 시작하는 경우
                        BFirst(k, l, chessBoard[k][l]);
                        // W 먼저 시작하는 경우
                        WFirst(k, l, chessBoard[k][l]);
                    }
                }
                int m = Math.min(firstB, firstW);
                if(minChange > m){
                    minChange = m;
                }
            }
        }

        System.out.println(minChange);
        br.close();
    }

    public static void BFirst(int k, int l, char c) {
        //행, 열, 그 위의 문자를 인자로 받는다.

        //(1) 만약 B로 먼저 시작한다면
        if (k % 2 == 0) {
            //짝수 행은 무조건 B로 시작해야 한다.
            if (l % 2 == 0 && c != 'B') {
                //짝수 열은 B가 와야 한다.
                //짝수 열에 B가 오지 않은 경우의 수를 센다.
                firstB++;
            } else if (l % 2 == 1 && c != 'W') {
                firstB++;
            }
        } else {
            //홀수 행은 W로 시작해야 한다.
            if (l % 2 == 0 && c != 'W') {
                //짝수 열에는 W가 와야 한다.
                //짝수 열에 W가 오지 않은 경우의 수를 센다.
                firstB++;
            } else if (l % 2 == 1 && c != 'B') {
                firstB++;
            }
        }
    }

    public static void WFirst ( int k, int l, char c){
        //(2) 만약 W로 먼저 시작한다면
        if (k % 2 == 0) {
            //짝수 행은 무조건 W로 시작해야 한다.
            if (l % 2 == 0 && c != 'W') {
                firstW++;
            } else if (l % 2 == 1 && c != 'B') {
                firstW++;
            }
        } else {
            //홀수 행은 B로 시작해야 한다.
            if (l % 2 == 0 && c != 'B') {
                firstW++;
            } else if (l % 2 == 1 && c != 'W') {
                firstW++;
            }
        }
    }

}
