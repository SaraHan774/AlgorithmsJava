package com.gahee.algorithms.coursera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SCC2 {

    private static final int NUM_ARR = 875715;
    private static final String FILE_PATH = "src\\com\\gahee\\algorithms\\coursera\\scc.txt";

    static int time = 0;
    static boolean [] visited = new boolean[NUM_ARR];

    public static void main(String[] args) throws IOException {

        File file = new File(FILE_PATH);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        //오리지널 그래프
        ArrayList<Integer> [] graph = new ArrayList[NUM_ARR];
        //역방향 그래프
        ArrayList<Integer> [] graphRev = new ArrayList[NUM_ARR];
        //그래프 만들기 - 방향 그래프임. SCC 를 구해서 상위 다섯 개의 컴포넌트 사이즈를 답으로 입력하기.

        //인접 리스트를 만들기 위한 리스트
        ArrayList<Integer> list;

        //파일에서 1열과 2열의 숫자들을 한줄씩 읽어들여서 정점과 인접된 정점들에 대한
        //인접 리스트를 만든다.
        while ((line = bufferedReader.readLine()) != null) {
            String [] row = line.split(" ");
            int vertexFrom = Integer.parseInt(row[0]);
            int vertexTo = Integer.parseInt(row[1]);

            list = graph[vertexFrom];
            buildGraph(graph, list, vertexFrom, vertexTo);

            list = graph[vertexTo];
            buildGraph(graphRev, list, vertexTo, vertexFrom);
        }

        //finished time 을 기록하기 위한 배열을 만들기.
        int [] finishedTime = new int[NUM_ARR]; //우선은 100만으로 초기화

        depthFirstLoopRev(graphRev, finishedTime);

        Arrays.fill(visited, false);

        //depthFirstLoop(graph, finishedTime, visited);
        //System.out.println(Arrays.toString(finishedTime));
    }

    private static void depthFirstLoop(
            ArrayList<Integer> [] graph,
            int[] finishedTime,
            boolean[] visited) {

        //finishing time 의 내림차순으로 노드들을 처리하기


    }

    private static void depthFirstLoopRev(
            ArrayList<Integer> [] graphRev,
            int[] finishedTime) {

        for (int i = 0; i < graphRev.length; i++) {
            if(graphRev[i] == null){
                continue;
            }
            if(!visited[i]){
                depthFirstSearch(graphRev, i, finishedTime);
            }
        }
    }

    private static void depthFirstSearch(
            ArrayList<Integer> [] graphRev,
            int node,
            int [] finishedTime) {
        if(visited[node]){
            return;
        }
        //DFS 를 한다.
        visited[node] = true;
        ArrayList<Integer> adjList = graphRev[node];

        if(adjList == null){
            return;
        }

        for (int w : adjList) {
            if (!visited[w]) {
                depthFirstSearch(graphRev, w, finishedTime);
            }
        }
        time++;
        finishedTime[node] = time;
    }

    private static void buildGraph(
            ArrayList<Integer>[] graph,
            ArrayList<Integer> list,
            int vertexFrom, int vertexTo) {

        if(list == null){
            list = new ArrayList<>();
        }
        list.add(vertexTo);
        graph[vertexFrom] = list;
    }
}
