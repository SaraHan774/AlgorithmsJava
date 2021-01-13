package com.gahee.algorithms.test;

import java.util.Arrays;

public class OptimalSwap {

    public static void main(String[] args) {
        int [] arr = {10, 40, 30, 20};
        int [] arr2 = {3, 7, 2, 8, 6, 4, 5, 1};
        System.out.println(solution(arr2, 3));
    }

    public static int solution(int [] arr, int K){
        int answer = 0;
        int len = arr.length;
        int [][]map = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map[i][j] = Math.abs(arr[i] - arr[j]);
            }
        }

        System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < len; i++) {
            int cur = arr[i];
            int [] curArr = map[i];

            if(i == 0){
                if(curArr[i + 1] > K){
                    System.out.println(cur + " should be swapped");

                }
            }else if(i == len - 1){
                if(curArr[i - 1] > K){
                    System.out.println(cur + " should be swapped");
                }
            }else{
                if(curArr[i + 1] > K || curArr[i - 1] > K){
                    System.out.println(cur + " should be swapped");
                }
            }
        }


        return answer;
    }
}
