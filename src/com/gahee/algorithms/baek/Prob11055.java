package com.gahee.algorithms.baek;

import java.io.*;
import java.util.StringTokenizer;

public class Prob11055 {
/*Longest Common Subsequence Problem.
* A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에 합이 가장 큰 증가 부분
* 수열은 A = {1(V), 100, 2(V), 50(V), 60(V), 3, 5, 6, 7, 8} 이고, 합은 113이다.
* 첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
* 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
*
*/

//예제 인풋 -> 아웃풋 113
//10
//1 100 2 50 60 3 5 6 7 8
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N; //number of elements in an array
        int [] arr;

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        //storing elements in the array
        arr = new int[N];
        int [] sum = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i];
        }


        for (int i = 0; i < N; i++) {
            //1 까지의 증가수열의 합 최대
            //1, 100 까지의 증가수열의 합 최대
            //1, 100, 2 ...
            //1, 100, 2, 50 ...
            //1, 100, 2, 50, 60 ...
            //1, 100, 2, 50, 60, 3 ...

            for (int j = 0; j < i; j++) {

                if(arr[i] > arr[j]){
                    System.out.printf("Max(sum[%d] + arr[%d] = %d, sum[%d] = %d)\n", j, i, sum[j] + arr[i], i, sum[i]);
                    sum[i] = Math.max(sum[j] + arr[i], sum[i]);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            if(max < sum[i]){
                max = sum[i];
            }
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }


}
