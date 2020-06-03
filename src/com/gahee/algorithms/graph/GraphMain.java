package com.gahee.algorithms.graph;

public class GraphMain {

    public static void main(String[] args) {

        GraphDFS graphDFS = new GraphDFS();

        graphDFS.addEdge(0, 1, 1);
        graphDFS.addEdge(0, 2, 1);
        graphDFS.addEdge(0, 4, 1);
        graphDFS.addEdge(1, 2, 1);
        graphDFS.addEdge(2, 3, 1);
        graphDFS.addEdge(2, 4, 1);
        graphDFS.addEdge(3, 4, 1);

        graphDFS.showAdjacentVertex(0);
        graphDFS.showAdjacentVertex(1);
        graphDFS.showAdjacentVertex(2);
        graphDFS.showAdjacentVertex(3);
        graphDFS.showAdjacentVertex(4);

        graphDFS.doDFS(0);
    }
}
