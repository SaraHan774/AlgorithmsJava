package com.gahee.algorithms.graph;

public class GraphMain {

    public static void main(String[] args) {

        GraphMST graphMST = new GraphMST();

        graphMST.addEdge(0, 1, 1);
        graphMST.addEdge(0, 2, 3);
        graphMST.addEdge(0, 4, 5);
        graphMST.addEdge(1, 2, 2);
        graphMST.addEdge(1, 4, 4);
        graphMST.addEdge(2, 3, 7);
        graphMST.addEdge(2, 4, 6);
        graphMST.addEdge(3, 4, 8);

        graphMST.sortEdges();
        graphMST.doMST();

    }
}
