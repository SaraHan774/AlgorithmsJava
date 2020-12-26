package com.gahee.algorithms.programmers;

import java.util.*;

public class Network1 {

    public static void main(String[] args) {
        int [][] comp = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        int n = 3;
        int ans = solution(n, comp);
        System.out.println(ans);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        //컴퓨터에 대한 연결 관계가 행렬로 주어졌을 때 연결된 컴포넌트들의 개수 리턴하기

        boolean [] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        int [] track = new int[n];
        for (int i = 0; i < n; i++) {
            if(visited[i]){
                continue;
            }

            queue.add(i);
            visited[i] = true;
            // cur 을 탐색을 시작하는 정점으로 지정한다.
            track[i] = i;

            while(!queue.isEmpty()){
                int k = queue.poll();
                int [] nodes = computers[k];

                for (int j = 0; j < nodes.length; j++) {
                    if(!visited[j] && nodes[j] == 1){
         //               System.out.println(i + " 에서 " + j + " 방문");
                        track[j] = i;
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }
            Arrays.fill(visited, false);
            //System.out.println(Arrays.toString(track));
        }

        for (int j : track) {
            set.add(j);
        }
        answer = set.size();

        return answer;
    }
}
