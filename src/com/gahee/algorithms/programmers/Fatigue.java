package com.gahee.algorithms.programmers;

public class Fatigue {
    //https://school.programmers.co.kr/learn/courses/30/lessons/87946
    public static void main(String[] args) {
        int [][] arr = {
                {70, 10},
                {80, 20},
                {50, 40},
                {30, 10}
        };

        Solution solution = new Solution();
        int ans = solution.solution(70, arr);
        System.out.println(ans);
    }

    private static class Solution {

        private int max = 0;

        public int solution(int k, int[][] dungeons) {
            // 전부 다 방문해야 한다
            int [] visited = new int[dungeons.length];
            // 상태
            // A -> A' -> A'' ...
            // dungeon 배열, 방문 여부, 차감된 피로도, 탐색 지점 개수
            explore(dungeons, visited, k, 0);
            return max;
        }

        private void explore(int[][] dungeons, int[] visited, int k, int count) {
            for (int i = 0; i < dungeons.length; i++) {
                if (visited[i] == 0 && k >= dungeons[i][0]) {
                    visited[i] = 1;
                    explore(dungeons, visited, k - dungeons[i][1], count + 1);
                    visited[i] = 0;
                }
            }

            if (max < count) {
                max = count;
            }
        }

    }
}
