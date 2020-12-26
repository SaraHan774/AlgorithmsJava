package com.gahee.algorithms.graph;

import java.util.Stack;

public class GraphDFS {
    private static final int NUM_VERTEX = 5;

    private Stack<Integer> stack = new Stack<>();
    private int [] visited = new int[NUM_VERTEX];
    private Node [] graph = new Node[NUM_VERTEX];


    //Node v1과 v2 를 연결한다.
    public void addEdge(int v1, int v2, int doReverse){
        Node newNode = new Node(v2, null);
        Node curNode = graph[v1];

        if(curNode == null){
            graph[v1] = newNode;
        }else{
            //현재 노드의 다음 노드가 null 이 아닐때까지 탐색
            while(curNode.next != null){
                //다음 노드로 이동
                curNode = curNode.next;
            }
            //다음 노드가 null 이므로 마지막 노드이다.
            //새로운 노드를 마지막 노드의 다음 노드로 연결한다.
            curNode.next = newNode;
        }
        if(doReverse == 1){
            //v2 와 v1 을 연결한다.
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

    //정점 v 로부터 탐색을 시작한다.
    public void doDFS(int v){
        System.out.println("visited " + v);
        visited[v] = 1; //정점을 방문했다고 표시한다.
        stack.push(v); //일단 스택에 넣고 시작한다.

        //stack 이 비어있지 않을 동안
        while(!stack.isEmpty()){
            int nextVertex;
            nextVertex = findNextVertex(stack.peek());
            if(nextVertex == -1){
                //더 이상 stack 의 top 에 있는 것으로는 확인 불가.
                //갈 데가 없으므로 백트래킹
                stack.pop();
            }else{
                System.out.println("visited " + nextVertex);
                visited[nextVertex] = 1;
                stack.push(nextVertex);
            }
        }
    }

    //현재 정점과 연결된 다음 노드를 찾는다.
    public int findNextVertex(int v){
        Node curNode = graph[v];

        while(curNode != null){
            if(visited[curNode.v] == 0){
                return curNode.v;
            }
            curNode = curNode.next;
        }
        return -1;
    }

    public class Node{
        //본 클래스에서만 사용될 것이므로 private inner class 로 만들었다.
        int v;
        Node next;

        Node(int v, Node next){
            this.v = v;
            this.next = next;
        }
    }
}
