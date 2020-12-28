package com.gahee.algorithms.coursera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class KosarajuAlgorithm {

    private static final int NUM_ARR = 875715;
    private static final String FILE_PATH = "src\\com\\gahee\\algorithms\\coursera\\scc.txt";

    public static void main(String[] args) throws IOException {

        //create file object
        File file = new File(FILE_PATH);
        //get file reader
        FileReader fileReader = new FileReader(file);
        //get buffered reader and pass file reader as an argument.
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        KGraph graph = new KGraph(NUM_ARR);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String [] row = line.split(" ");
            int vertexFrom = Integer.parseInt(row[0]);
            int vertexTo = Integer.parseInt(row[1]);
            graph.addEdge(vertexFrom, vertexTo);
        }

        graph.printSCCs();
    }
}


class KGraph{
    private int v; //정점의 개수
    private LinkedList<Integer> adjList [];

    public KGraph(int v){
        this.v = v;
        adjList = new LinkedList[v];
        //그래프를 미리 초기화하는 방법이 있음.
        for (int i = 0; i < v; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    //간선을 추가하는 함수! 간단하게 구현 가능.
    void addEdge(int v, int w){
        adjList[v].add(w);
    }

    void DFSUtil(int v, boolean [] visited){
        visited[v] = true;
        System.out.print(v + " ");
        int n;

        //정점과 연결된 노드들을 가져와서 순회한다.
        Iterator<Integer> it = adjList[v].iterator();
        while(it.hasNext()){
            n = it.next(); //정점을 하나 가져온다.
            if(!visited[n]){
                //탐색되지 않은 정점을 타고 들어가서 다시 탐색한다.
                DFSUtil(n, visited);
            }
        }
    }

    KGraph getTranspose(){
        //동일한 개수의 정점으로 초기화된 그래프
        KGraph graph = new KGraph(v);
        for (int i = 0; i < v; i++) {
            //정점의 개수만큼 순회하면서
            Iterator<Integer> it = adjList[i].listIterator();
            //해당 정점과 연결된 정점들을 iterator 로 가져오고
            while(it.hasNext()){
                //정점이 있을 때 까지
                //원래는 i -> it.next() 로 가리키고 있었던 것들을
                // it.next() -> i 의 방향으로 바꾸어준다.
                graph.adjList[it.next()].add(i);
            }
        }
        return graph;
    }

    void fillOrder(int v, boolean [] visited, Stack<Integer> stack){
        //현재 노드를 방문했음으로 체크하고 프린트한다.
        visited[v] = true;
        Iterator<Integer> it = adjList[v].iterator();
        while(it.hasNext()){
            int n = it.next();
            if(!visited[n]){
                fillOrder(n, visited, stack);
            }
        }
        //v 로부터 방문 가능한 정점들은 프로세싱이 되어있음
        //스택에 푸시한다.
        stack.push(v);
    }

    void printSCCs(){
        Stack<Integer> stack = new Stack<>();

        //방문 배열을 false 로 초기화한다.
        boolean [] visited = new boolean[v];
        Arrays.fill(visited, false);

        //스택에 finishing time 에 맞게 정점들을 채워넣는다.
        for (int i = 0; i < v; i++) {
            if(!visited[i]){
                fillOrder(i, visited, stack);
            }
        }

        //역방향 그래프를 만든다.
        KGraph graph = getTranspose();

        Arrays.fill(visited, false);

        //스택에 들어있는 순서대로 정점들을 처리한다.
        while(!stack.isEmpty()){
            int v = stack.pop();
            if(!visited[v]){
                //SCC 를 프린트 한다.
                graph.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }
}