package com.gahee.algorithms.programmers;

import java.util.Arrays;

public class KthItem {

    public static void main(String[] args) {
        int [] arr = {1, 5, 2, 6, 3, 7, 4};
        int [][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };
        //i ... j 까지 자르고, 정렬
        //k 번째 있는 수를 구하려 함.
        //i = 2, j = 5, k = 3
        System.out.println(Arrays.toString(solution(arr, commands)));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int findIdx = commands[i][2];

            int [] arr;
            arr = Arrays.copyOfRange(array, start - 1, end);
            Arrays.sort(arr);
            answer[i] = arr[findIdx - 1];
        }

        return answer;
    }
}
