package com.gahee.algorithms.graph;

public class GraphMain {

    public static void main(String[] args) {


        GraphDijkstra dijkstra = new GraphDijkstra();

        dijkstra.addEdge(0, 1, 1, 1);
        dijkstra.addEdge(0, 2, 3, 1);
        dijkstra.addEdge(0, 4, 5, 1);
        dijkstra.addEdge(1, 2, 2, 1);
        dijkstra.addEdge(1, 4, 4, 1);
        dijkstra.addEdge(2, 3, 7, 1);
        dijkstra.addEdge(2, 4, 6, 1);
        dijkstra.addEdge(3, 4, 8, 1);

        dijkstra.initDtable();

        dijkstra.doDijkstra(0);
    }
}
