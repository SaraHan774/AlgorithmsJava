package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2798 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int max;
        int minDiff = Integer.MAX_VALUE;
        int diff;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
//                    System.out.println(cards[i] + ", " + cards[j] + ", " + cards[k]);
                    max = cards[i] + cards[j] + cards[k];
                    if(max == M){
                        //만약 M 과 같은 합이 나온다면 바로 프로그램을 종료한다.
                        System.out.println(max);
                        br.close();
                        System.exit(0);
                    }
                    // M 과 다를 경우, M과의 차이를 구한다.
                    diff = M - max;
                    if(diff < 0){ //만약 차이가 0보다 작으면 다음 루프로 넘어간다.
//                        System.out.println("continue, diff = " + diff);
                        continue;
                    }
                    // 만약 차이가 0보다 크거나 같은 경우, 차이가 최소가 되는지 확인한다.
                    if(minDiff >= diff){
                        minDiff = diff;
//                        System.out.println(minDiff);
                    }
                }
            }
        }
        // 최소의 차이와 M 값을 뺀 결과를 출력한다.
        System.out.println(M - minDiff);
        br.close();
    }
}
