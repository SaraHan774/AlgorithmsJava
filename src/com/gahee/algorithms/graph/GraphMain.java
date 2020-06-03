package com.gahee.algorithms.graph;

public class GraphMain {

    public static void main(String[] args) {

        GraphBFS graphBFS = new GraphBFS();

        graphBFS.addEdge(0, 1, 1);
        graphBFS.addEdge(0, 2, 1);
        graphBFS.addEdge(0, 4, 1);
        graphBFS.addEdge(1, 2, 1);
        graphBFS.addEdge(2, 3, 1);
        graphBFS.addEdge(2, 4, 1);
        graphBFS.addEdge(3, 4, 1);

//        graphBFS.showAdjacentVertex(0);
//        graphBFS.showAdjacentVertex(1);
//        graphBFS.showAdjacentVertex(2);
//        graphBFS.showAdjacentVertex(3);
//        graphBFS.showAdjacentVertex(4);
        graphBFS.doBFS(0);

    }
}
