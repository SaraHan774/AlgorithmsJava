package com.gahee.algorithms.baek;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//DFS 와 BFS
//그래프를 DFS 로 탐색한 결과와 BFS 로 탐색한 결과를 출력하는 프로그램
public class P1260 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String [] strings = line.split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        int V = Integer.parseInt(strings[2]);
        //N 은 정점의 개수, 1~1000, M 은 간선의 개수 1 ~ 10000
        //탐색을 시작할 정점의 번호 V
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>(N);
        ArrayList<Integer> list;
        String line1;
        for (int i = 0; i < M; i++) {
            line1 = br.readLine();
            String [] strings1 = line1.split(" ");
            int s = Integer.parseInt(strings1[0]);
            int t = Integer.parseInt(strings1[1]);

            list = graph.get(s);
            buildGraph(graph, list, s, t);

            list = graph.get(t);
            buildGraph(graph, list, t, s);
        }

        System.out.println(graph);
        boolean [] visited = new boolean[10001];
        depthFirstSearch(graph, V, visited);
        System.out.println();
        bredthFirstSearch(graph, V);
    }

    private static void buildGraph(
            HashMap<Integer, ArrayList<Integer>> graph,
            ArrayList<Integer> list,
            int s, int t){

        if(list == null){
            list = new ArrayList<>();
        }
        list.add(t);
        //노드가 여러개라면 번호가 낮은 순 부터 방문하므로
        Collections.sort(list);
        graph.put(s, list);
    }

    private static void bredthFirstSearch(HashMap<Integer, ArrayList<Integer>> graph, int v) {
        boolean[] visited = new boolean[10001];

        visited[v] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int k = queue.poll();
            System.out.print(k + " ");
            ArrayList<Integer> nodes = graph.get(k);

            //1 , 2 - 3 과 같이 연결이 되지 않은 그래프가 있을 수 있다.
            if(nodes != null) {
                for (int node : nodes) {
                    if (!visited[node]) {
                        queue.add(node);
                        visited[node] = true;
                    }
                }
            }else{
                //연결되지 않은 노드부터 탐색한다면 반드시 바로 종료해야 함.
                break;
            }
        }
    }

    private static void depthFirstSearch(HashMap<Integer, ArrayList<Integer>> graph, int v, boolean[] visited){
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        System.out.print(v + " ");
        ArrayList<Integer> nodes = graph.get(v);
        if(nodes != null) {
            //마찬가지로 노드가 연결이 되어 있는지 확인하고 탐색해야 함.
            for (Integer node : nodes) {
                if (!visited[node]) {
                    depthFirstSearch(graph, node, visited);
                }
            }
        }
    }
}
