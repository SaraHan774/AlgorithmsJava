package com.gahee.algorithms.coursera;

import java.io.*;
import java.util.*;

// 10 / 100 (self graded points)
public class KargerMinCut {

    private static final String FILE_PATH = "src\\com\\gahee\\algorithms\\coursera\\minCut.txt";

    public static void main(String[] args) throws IOException {
        //list 만들기
        ArrayList<Edge> edges = new ArrayList<>();

        File file = new File(FILE_PATH);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String [] strings = line.split("\t");

            int label = Integer.parseInt(strings[0]);

            for (int i = 1; i < strings.length; i++) {
                edges.add(new Edge(label, Integer.parseInt(strings[i])));
            }
        }
        bufferedReader.close();


//        System.out.println(Arrays.toString(edges.toArray()));
//        System.out.println(edges.size()); //5034


        Random random = new Random();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < 201; i++) {
            map.put(i, -1);
        }

        while(map.size() > 2){
            Edge edge = edges.get(random.nextInt(edges.size() - 1) + 1);
            int v1 = edge.first;
            int v2 = edge.second;

            //간선중에서 라벨이 v2 에 해당하는 것들을 모두
            //라벨 v1 으로 변경하기
            for (int i = 0; i < edges.size(); i++) {
                Edge e = edges.get(i);
                if(e.first == v2){
                    e.first = v1;
                    if(e.second == v1){
                        edges.remove(e);
                    }
                }
            }
            map.remove(v2);
        }

        System.out.println(edges.size());
        // 1, 37 을 합치려면 ?
        //37번 정점과 연결된 모든 정점들을 1번의 인접 정점에 포함시킨다.
        //37번 정점과 연결된 모든 정점들의 인접 정점에 1을 포함시킨다.
    }

    private static class Edge {
        int first;
        int second;

        @Override
        protected Object clone() {
            Edge edge = new Edge(this.first, this.second);
            return edge;
        }

        public Edge(int label, int adjacentV) {
            this.first = label;
            this.second = adjacentV;
        }

        @Override
        public String toString() {
            return "{" +
                     first +
                    ", " +  second +
                    "}\n";
        }
    }

}
