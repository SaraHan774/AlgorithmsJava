package com.gahee.algorithms.coursera;

import java.io.*;
import java.util.*;
/**
 * Coursera Algorithms Stanford Programming Assignment 2-2
 * 2599
 * 2610
 * 2947
 * 2052
 * 2367
 * 2399
 * 2029
 * 2442
 * 2505
 * 3068
 * */
public class ShortestPath {
    private static final String FILE_PATH = "src\\com\\gahee\\algorithms\\coursera\\programming2_2.txt";
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;

        try {
            File file = new File(FILE_PATH);
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ShortestPathAlg shortestPathAlg = new ShortestPathAlg();

        String line;
        while(true){
            try {
                if (((line = bufferedReader.readLine()) == null)) {
                    break;
                }else{
                    String [] sub = line.split("[\t ]");
                    int s = Integer.parseInt(sub[0]);
                    for (int i = 1; i < sub.length; i++) {
                        String [] node  = sub[i].split(",");
                        int to = Integer.parseInt(node[0]);
                        int length = Integer.parseInt(node[1]);
                        shortestPathAlg.addEdge(s, to, length);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int [] targets = {7,37,59,82,99,115,133,165,188,197};
        shortestPathAlg.computeShortestPath(1);
//        System.out.println(Arrays.toString(shortestPathAlg.D));
        shortestPathAlg.printDistance(targets);
    }

    private static class ShortestPathAlg{
        private ArrayList<Edge> [] graph = new ArrayList[201];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        private boolean [] visited = new boolean[201];
        Node [] D = new Node[201];


        public void addEdge(int from, int to, int length){
            ArrayList<Edge> list = graph[from];
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(new Edge(from, to, length));
            graph[from] = list;
        }

        public void printDistance(int [] targets){
            for (int target : targets) {
                System.out.println(D[target]);
            }
        }


        public void computeShortestPath(int from){
            for (int i = 1; i < graph.length; i++) {
                if(i == from){
                    D[i] = new Node(i, 0);
                }else{
                    D[i] = new Node(i, 1000_000);
                }
                pq.add(D[i]);
            }

            while(!pq.isEmpty()){
                Node cur = pq.poll();
                ArrayList<Edge> edges = graph[cur.vertex];

                if(edges == null){
                    continue;
                }

                for (Edge edge : edges) {

                    if(!visited[edge.vertextTo] &&
                    D[edge.vertextTo].distance > D[cur.vertex].distance + edge.length){
                        D[edge.vertextTo].distance = D[cur.vertex].distance + edge.length;
                        pq.remove(D[edge.vertextTo]);
                        pq.add(D[edge.vertextTo]);
                    }

                    System.out.println(pq);
                }
                visited[cur.vertex] = true;
            }
        }

        public ArrayList<Edge>[] getGraph() {
            return graph;
        }
    }

    private static class Edge{
        int vertexFrom;
        int vertextTo;
        int length;

        public Edge(int vertexFrom, int vertextTo, int length) {
            this.vertexFrom = vertexFrom;
            this.vertextTo = vertextTo;
            this.length = length;
        }

        @Override
        public String toString() {
            return vertextTo + "(" + length + ")";
        }
    }

    private static class Node implements Comparable<Node>{
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.distance, o.distance);
        }

        @Override
        public String toString() {
            return "V : " + vertex + " D: " + distance + "  ";
        }
    }
}
