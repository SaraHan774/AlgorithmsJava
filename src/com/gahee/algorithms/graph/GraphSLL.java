package com.gahee.algorithms.graph;

public class GraphSLL {

    static Node [] graph = new Node[4];
    //Node 를 담을 그래프의 배열을 만든다.

    static void addEdge(int v1, int v2){
        Node curNode = graph[v1];

        if(curNode == null){
            graph[v1] = new Node(v2, null);
        }else{
            while(curNode.nextNode != null){
                curNode = curNode.nextNode;
            }
            curNode.nextNode = new Node(v2, null);
        }
    }

    static void showAdjacentVertex(int v){
        Node curNode = graph[v];
        while(curNode != null){
            System.out.println(curNode.v + " is the adjancent vertex of " + v);
            curNode = curNode.nextNode;
        }
    }

    public static void main(String[] args) {

        addEdge(1, 2);
        addEdge(2, 1);
        addEdge(0, 1);
        addEdge(1, 0);
        addEdge(2, 0);
        addEdge(0, 2);

        showAdjacentVertex(1);
        showAdjacentVertex(0);
        showAdjacentVertex(2);
    }
}

class Node{
    int v;
    Node nextNode;

    public Node(int v, Node nextNode){
        this.v = v;
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "v=" + v +
                ", nextNode=" + nextNode +
                '}';
    }
}