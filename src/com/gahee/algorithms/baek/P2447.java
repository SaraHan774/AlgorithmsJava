package com.gahee.algorithms.baek;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2447 {

    public static void main(String[] args) throws IOException {

        //재귀적인 패턴으로 별을 찍어보자
        //N 은 3의 거듭제곱 N * N 정사각형 모양
        // 공백 가운데, 가운데 제외한 모든 칸에 별 하나씩
        // N이 3보다 크면, 크기 N의 패턴은 공백으로 채워진 N/3 * N/3 정사각형을
        // 크기 N/3 의 패턴으로 둘러싼 형태
        // k = 1~ 8
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        otherAnswer(N);

        //N이 3의 거듭제곱인지 판별하기
//        int k = 0;
//        int M = N;
//        while(M != 1){
//            M /= 3;
//            k++;
//        }
//        System.out.println(k);
//        //3승이므로 3*3 -> 3*3 -> 3*3 점점 커지는 형태로 만들어야 함
//        StringBuilder sb = new StringBuilder();
//        String star = "*";
//
//        draw(star, N, k);

        br.close();

    }

    private static void draw(String star,int N, int k) {
        for (int i = 1; i <= 3; i++) {
            System.out.print(star);
        }
        System.out.println();
        for (int i = 1; i <= 3; i++) {
            if(i > Math.pow(3, k-1) && i <= N - Math.pow(3, k-1)){
                System.out.print(" ");
            }else{
                System.out.print(star);
            }
        }
        System.out.println();
        for (int i = 1; i <= 3; i++) {
            System.out.print(star);
        }
    }

    static char [][] map = new char[3000][3000];

    private static void otherAnswer(int N){

        for (int i = 0; i < 3000; ++i) {
            for (int j = 0; j < 3000; j++) {
                map[i][j] = ' ';
            }
        }

        solve(N, 0, 0);

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void solve(int n, int i, int j) {
        if(n == 1){
            map[i][j] = '*';
            return;
        }
        int div = n/3;
        for (int k = 0; k < n; ++k) {
            for (int l = 0; l < 3; ++l) {
                if (k == 1 && j== 1){
                    continue;
                }
                solve(div, i + (div * k), j + (div * l));
            }
        }
    }


}
