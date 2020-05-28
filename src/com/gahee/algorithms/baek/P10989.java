package com.gahee.algorithms.baek;

import java.io.*;

public class P10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];


        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]){
                max = arr[i];
            }
        }

        int[] countArr = new int[max + 1];

        for (int i = 0; i < N; i++) {
            countArr[arr[i]]++;
        }

        //countArr 에 등장한 횟수를 확인하자
        for (int i = 1; i <= max; i++) {
            int M = countArr[i];

            for (int j = 0; j < M; j++) {
                arr[j] = i;
                bw.write(i +"\n");
            }
        }
        br.close();
        bw.close();
    }
}
