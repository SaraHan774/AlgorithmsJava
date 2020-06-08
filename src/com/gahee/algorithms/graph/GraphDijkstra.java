package com.gahee.algorithms.graph;


public class GraphDijkstra {

    private static final int NUM_VERTEX = 5;
    private static final int NUM_EDGES = 8;

    private class Node{
        int vertex;
        int weight;
        Node next;
        public Node(int vertex, int wieght, Node next){
            this.vertex = vertex;
            this.weight = wieght;
            this.next = next;
        }
    }

    private Node [] graph = new Node[NUM_VERTEX];

    private class Dijkstra{
        int found;
        int distance;
        int prevVertex;
        public Dijkstra(int found, int distance, int prevVertex) {
            this.found = found;
            this.distance = distance;
            this.prevVertex = prevVertex;
        }
    }

    private Dijkstra [] dTable = new Dijkstra[NUM_VERTEX];

    public void addEdge(int v1, int v2, int weight, int doReverse){
        Node newNode = new Node(v2, weight, null);
        Node curNode = graph[v1];

        if(curNode == null){
            graph[v1] = newNode;
        }else{
            while(curNode.next != null){
                curNode = curNode.next;
            }
            curNode.next = newNode;
        }

        if(doReverse == 1){
            addEdge(v2, v1, weight, 0);
        }
    }


    public void initDtable(){
        for (int i = 0; i < NUM_VERTEX; i++) {
            dTable[i] = new Dijkstra(0, 99999, -1);
        }
    }


    public int findDijkstraNextVertex(){
        int shortestDistance = 99999;
        int smallestVertex = -1;
        for (int i = 0; i < NUM_VERTEX; i++) {
            if(dTable[i].found == 0 &&
            dTable[i].distance < shortestDistance){
                shortestDistance = dTable[i].distance;
                smallestVertex = i;
            }
        }
        return smallestVertex;
    }


    public void showDtable(){
        for (int i = 0; i < NUM_VERTEX; i++) {
            System.out.printf("%d : %d %d %d \n",
                    i,
                    dTable[i].found,
                    dTable[i].distance,
                    dTable[i].prevVertex
            );
        }
    }

    public void updateDtable(int v){
        Node curNode = graph[v];
        while(curNode != null){

            if(dTable[curNode.vertex].found == 0 &&
            dTable[curNode.vertex].distance > dTable[v].distance + curNode.weight){
                dTable[curNode.vertex].distance = dTable[v].distance + curNode.weight;
                dTable[curNode.vertex].prevVertex = v;
            }
            curNode = curNode.next;
        }
    }


    public void doDijkstra(int v){
        int nextVertex = -1;
        dTable[v].distance = 0;

        while ((nextVertex = findDijkstraNextVertex()) != -1){
            dTable[nextVertex].found = 1; //최단 거리를 찾았다고 표시
            updateDtable(nextVertex);
        }
        showDtable();
    }

}
