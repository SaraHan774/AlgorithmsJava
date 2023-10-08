package com.gahee.algorithms.programmers;


import java.util.Arrays;
import java.util.Comparator;

public class Shooting {

    public static void main(String[] args) {
        int[][] arr = {
                {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}
        };

        Solution solution = new Solution();
        int ans = solution.solution(arr);
        System.out.println(ans);
    }

    public static class Solution {

        public int solution(int[][] targets) {
            int answer = 1;

            Arrays.sort(targets, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

            int prevStart = targets[0][0];
            int prevEnd = targets[0][1];

            for (int[] cur : targets) {
                int curStart = cur[0]; // 1
                int curEnd = cur[1]; // 4

                if (prevStart <= curStart && curStart < prevEnd) { // 시작점이 현재 구간 안에 떨어지면
                    // 시작 구간은 더 큰 값을 기준으로 변경
                    prevStart = curStart; // 항상 더 크거나 같으므로
                    // 끝나는 구간은 더 작은 값을 기준으로 변경
                    prevEnd = Math.min(prevEnd, curEnd);
                } else {
                    // 겹치는 구간이 없다
                    prevStart = curStart;
                    prevEnd = curEnd;
                    answer += 1; // 분절된 덩어리에 대한 카운트를 진행
                }
            }
            return answer;
        }
    }
}
