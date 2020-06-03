package com.gahee.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {

    private static final int NUM_VERTEX = 5;
    //형제 vertext 들을 담을 자료구조
    private Queue<Integer> queue = new LinkedList<>();
    //방문한 곳을 표시해둘 visited 배열
    private int [] visited = new int[NUM_VERTEX];
    //그래프를 표현할 배열
    private Node [] graph = new Node[NUM_VERTEX];


    //간선을 추가하는 메서드. DFS 와 동일하다.
    public void addEdge(int v1, int v2, int doReverse){
        Node curNode = graph[v1];
        Node newNode = new Node(v2, null);

        if(curNode == null){
            graph[v1] = newNode;
        }else{
            while(curNode.next != null){
                curNode = curNode.next;
            }
            curNode.next = newNode;
        }
        if(doReverse == 1){
            addEdge(v2, v1, 0);
        }
    }

    public void showAdjacentVertex(int v){
        Node curNode = graph[v];
        while(curNode != null){
            System.out.println(curNode.v + " is the adjacent vertex of " + v);
            curNode = curNode.next;
        }
    }

    //넓이 우선 탐색을 진행한다.
    public void doBFS(int v){
        queue.add(v); //방문한 정점을 큐에 넣는다.
        visited[v] = 1; //방문 했다고 표시한다.
        System.out.println("visited " + v);

        while(!queue.isEmpty()){
            //queue 의 front 와 연결된 간선이 있는가?
            int front = queue.poll();
            Node curNode = graph[front];

            while(curNode.next != null){
                curNode = curNode.next;
                //queue 의 front 와 연결된 정점들을 방문 했는가?
                if(visited[curNode.v] != 1){
                    visited[curNode.v] = 1;
                    queue.add(curNode.v);
                    System.out.println("visited " + curNode.v);
                }
            }

        }
    }

    private class Node{
        int v;
        Node next;

        Node(int v, Node next){
            this.v = v;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "v=" + v +
                    ", next=" + next +
                    '}';
        }
    }
}
