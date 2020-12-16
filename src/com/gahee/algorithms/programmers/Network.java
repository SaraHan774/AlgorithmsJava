package com.gahee.algorithms.programmers;

import java.util.*;

public class Network {

    public static void main(String[] args) {
        int [][] comp = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };
        int n = 3;
        solution(n, comp);
    }

    public static int solution(int n, int [][] computers){
        int answer = 1;

        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

        for (int i = 0; i < computers.length; i++) {
            ArrayList<Integer> adjList = new ArrayList<>();
            for (int j = 0; j < computers[i].length; j++){
                if(i == j){ continue; }
                if(computers[i][j] == 1){
                    adjList.add(j);
                }
            }
            graph.put(i, adjList);
        }
//        System.out.println(graph);

        boolean [] visited = new boolean[n];
        int [] edgeTo = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(visited[i]){
                continue;
            }
            stack.push(i);
            visited[i] = true;
            edgeTo[i] = i;


            while(!stack.isEmpty()){
                int cur = stack.pop();

                ArrayList<Integer> curList = graph.get(cur);

                for (int v : curList) {
                    if (!visited[v]) {
                        visited[v] = true;
                        stack.push(v);
                        edgeTo[v] = cur;
                    }
                }
            }
        }

//        System.out.println(Arrays.toString(visited));
//        System.out.println(Arrays.toString(edgeTo));


        for (int i = 0; i < edgeTo.length - 1; i++) {
            if(edgeTo[i+1] - edgeTo[i] > 1){
                answer++;
            }
        }

        //System.out.println(answer);
        return answer;
    }
}
