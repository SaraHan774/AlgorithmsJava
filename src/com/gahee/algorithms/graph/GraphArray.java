package com.gahee.algorithms.graph;

public class GraphArray {

    static int [][] graph = new int[4][4];

    public static void addEdge(int v1, int v2){
        graph[v1][v2] = 1;
        graph[v2][v1] = 1;
    }

    public static void showAdjacentVertex(int v){
        for (int i = 0; i < 4; i++) {
            if(graph[v][i] == 1){
                System.out.println(
                        i + " is the adjacent vertex of " + v
                );
            }
        }
    }

    public static void main(String[] args) {

        addEdge(1, 2);
        addEdge(1, 3);

        showAdjacentVertex(1);
    }
}
