package com.gahee.algorithms.graph;

import java.util.Arrays;
import java.util.Comparator;

public class GraphMST {

    private static final int NUM_VERTEX = 5;
    private static final int NUM_EDGES = 8;

    //간선을 담을 공간과 정점을 담을 공간을 확보한다.
    private Edge [] edges = new Edge[NUM_EDGES];
    private Node [] graph = new Node[NUM_VERTEX];

    private int [] cycleDetection = {0 ,1, 2, 3, 4};

    private class Edge{
        int fromV;
        int toV;
        int weight;
        Edge(int fromV, int toV, int weight){
            this.fromV = fromV;
            this.toV = toV;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "fromV=" + fromV +
                    ", toV=" + toV +
                    ", weight=" + weight +
                    '}';
        }
    }

    private class Node{
        int v;
        int weight;
        Node next;
        Node(int v, int weight, Node next){
            this.v = v;
            this.weight = weight;
            this.next = next;
        }
    }

    //인자 값으로 weight 를 넣어준다.
    public void addEdge(int v1, int v2, int weight){
        //새로운 노드를 만든다.
        Node newNode = new Node(v2, weight, null);
        //현재 노드를 담을 공간을 참조한다.
        Node curNode = graph[v1];

        if(curNode == null){
            graph[v1] = newNode;
        }else{
            while(curNode.next != null){
                curNode = curNode.next;
            }
            curNode.next = newNode;
        }
        //역방향은 담지 않는다.
    }


    //MST 를 하기 전에 edge 들을 weight 순서대로 정렬해 주어야 한다.
    //오름차순으로 정렬한다.
    public void sortEdges(){
        int edges_index = 0;

        //간선을 담는 배열에 모든 간선들을 추가해준다.
        for (int i = 0; i < NUM_VERTEX; i++) {
            Node curNode = graph[i]; //0에 들어가있는 첫번째 노드가 반환된다.
            while(curNode != null){
                Edge edge = new Edge(i, curNode.v, curNode.weight);
                edges[edges_index++] = edge;
                curNode = curNode.next;
            }
        }

        Arrays.sort(edges, (o1, o2) -> {
            if(o1.weight > o2.weight){
                return 1;
            }else if(o1.weight < o2.weight){
                return -1;
            }
            return 0;
        });
        //간선들을 출력해본다.
        for (int i = 0; i < NUM_EDGES; i++) {
            System.out.println(edges[i]);
        }
    }


    //앞 순서의 숫자로 배열 요소를 바꿈으로서 같은 그룹에 속하게 한다.
    public void putIntoSameGroup(int v1, int v2){
        int g1 = cycleDetection[v1];
        int g2 = cycleDetection[v2];

        for (int i = 0; i < NUM_VERTEX; i++) {
            if(cycleDetection[i] == Math.max(g1, g2)){
                cycleDetection[i] = Math.min(g1, g2);
            }
        }
    }

    public void doMST(){
        //간선들이 정렬되어 있으므로 하나씩 더해가면서
        //사이클이 생기는 애들은 빼고, 아닌 애들만 출력한다.
        int mst_edges = 0;

        for (int i = 0; i < NUM_EDGES; i++) {
            //같은 그룹에 속해있지 않다면
            if(cycleDetection[edges[i].fromV] != cycleDetection[edges[i].toV]){
                System.out.println("MST Edge " + edges[i].fromV + " === " + edges[i].toV + " W : " + edges[i].weight);
                mst_edges++; //0, 1, 2, 3, 4 까지 가면 마지막이므로
                if(mst_edges == NUM_VERTEX - 1){
                    //만약 모든 정점을 다 순회했다면 리턴한다.
                    return;
                }
                // 같은 그룹에 속하게 한다.
                putIntoSameGroup(edges[i].fromV, edges[i].toV);
            }
        }
    }


}
