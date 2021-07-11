package com.gahee.algorithms.coursera;

import java.io.*;
import java.util.*;

public class SCC {

    private static final String FILE_PATH = "src\\com\\gahee\\algorithms\\coursera\\scc.txt";

    private static LinkedList<Integer>[] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        File file = new File(FILE_PATH);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        GraphDFS graphDFS = new GraphDFS();
        GraphDFS graphDFS1 = new GraphDFS();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] row = line.split(" ");
            int vertexFrom = Integer.parseInt(row[0]);
            int vertexTo = Integer.parseInt(row[1]);
            graphDFS1.addEdge(vertexTo, vertexFrom);
        }

        // System.out.println(Arrays.toString(graphDFS.getGraph()));

        graphDFS1.dfsLoop(true);

        Node[] arr = graphDFS1.getGraph();
        Arrays.sort(arr, (o1, o2) -> -Integer.compare(o1.finishedTime, o2.finishedTime));

        graphDFS1.setGraph(arr);

        System.out.println(Arrays.toString(graphDFS1.getGraph()));
    }

}

class GraphDFS {
    private static final int NUM_VERTEX = 900000;

    private Stack<Integer> stack = new Stack<>();
    private int[] visited = new int[NUM_VERTEX];
    private Node[] graph = new Node[NUM_VERTEX];

    int time = 0;
    Node leader = null;

    public GraphDFS() {
        Arrays.fill(graph, new Node(-1, null));
    }

    public Node[] getGraph() {
        return graph;
    }

    public void setGraph(Node[] graph) {
        this.graph = graph;
    }

    public void dfsLoop(boolean isReversed) {
        for (int i = graph.length - 1; i > 0; i--) {
            if (graph[i].v != -1 && visited[i] != 1) {
                leader = graph[i];
                doDFS(graph[i].v, isReversed);
            }
        }
    }

    // Node v1과 v2 를 연결한다.
    public void addEdge(int v1, int v2) {
        Node newNode = new Node(v2, null);
        Node curNode = graph[v1];

        if (curNode == null) {
            graph[v1] = newNode;
        } else {
            // 현재 노드의 다음 노드가 null 이 아닐때까지 탐색
            while (curNode.next != null) {
                // 다음 노드로 이동
                curNode = curNode.next;
            }
            // 다음 노드가 null 이므로 마지막 노드이다.
            // 새로운 노드를 마지막 노드의 다음 노드로 연결한다.
            curNode.next = newNode;
        }
    }

    public void showAdjacentVertex(int v) {
        Node curNode = graph[v];
        while (curNode != null) {
            System.out.println(curNode.v + " is the adjacent vertex of " + v);
            curNode = curNode.next;
        }
    }

    // 정점 v 로부터 탐색을 시작한다.
    public void doDFS(int v, boolean isReversed) {
        // System.out.println("visited " + v);
        visited[v] = 1; // 정점을 방문했다고 표시한다.
        stack.push(v); // 일단 스택에 넣고 시작한다.

        if (!isReversed && graph[v].v != -1) {
            graph[v].setLeader(leader);
        }

        // stack 이 비어있지 않을 동안
        while (!stack.isEmpty()) {
            int nextVertex;
            nextVertex = findNextVertex(stack.peek());
            if (nextVertex == -1) {
                // 더 이상 stack 의 top 에 있는 것으로는 확인 불가.
                // 갈 데가 없으므로 백트래킹
                stack.pop();
            } else {
                // System.out.println("visited " + nextVertex);
                visited[nextVertex] = 1;
                stack.push(nextVertex);
            }
        }
        if (isReversed && graph[v].v != -1) {
            time++;
            graph[v].setFinishedTime(time);
        }
    }

    // 현재 정점과 연결된 다음 노드를 찾는다.
    public int findNextVertex(int v) {
        Node curNode = graph[v];

        while (curNode != null) {
            if (visited[curNode.v] == 0) {
                return curNode.v;
            }
            curNode = curNode.next;
        }
        return -1;
    }
}

class Node {
    // 본 클래스에서만 사용될 것이므로 private inner class 로 만들었다.
    int v;
    int finishedTime;
    Node leader;
    Node next;

    Node(int v, Node next) {
        this.v = v;
        this.next = next;
    }

    public void setLeader(Node leader) {
        this.leader = leader;
    }

    public void setFinishedTime(int finishedTime) {
        this.finishedTime = finishedTime;
    }

    @Override
    public String toString() {
        return String.valueOf(v);
    }
}