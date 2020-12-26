package com.gahee.algorithms.coursera;

import java.io.*;
import java.util.*;

public class StronglyConnectedComponents {

    private static final String FILE_PATH = "src\\com\\gahee\\algorithms\\coursera\\scc.txt";

    public static void main(String[] args) throws IOException {

        File file = new File(FILE_PATH);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;

        //constructs a graph
        HashMap<DFSNode, ArrayList<DFSNode>> graph = new HashMap<>();
        HashMap<DFSNode, ArrayList<DFSNode>> graphRev = new HashMap<>();

        DFSNode tmp;
        DFSNode tmpRev;

        while ((line = bufferedReader.readLine()) != null) {
            String [] row = line.split(" ");
            int vertexFrom = Integer.parseInt(row[0]);
            int vertexTo = Integer.parseInt(row[1]);

            tmp = new DFSNode(vertexFrom);
            tmpRev = new DFSNode(vertexTo);

            ArrayList<DFSNode> list = graph.get(tmp);
            ArrayList<DFSNode> listRev = graphRev.get(tmpRev);

            //동일한 노드에 대한 참조를 두 개의 그래프에 동일하게 넘겨주되,
            //시작과 끝이 뒤바뀐 상태로 그래프를 만들어서 finishing time 을 측정한다.
            DFSNode startNode = new DFSNode(vertexFrom);
            DFSNode endNode = new DFSNode(vertexTo);

            makeGraph(graph, list, startNode, endNode);
            makeGraph(graphRev, listRev, endNode, startNode);
        }

        //System.out.println(graphRev);

        DFS dfs = new DFS(graphRev);
        dfs.runDFSLoop(true);

        System.out.println(dfs.visited);

//        DFS dfs1 = new DFS(graph);
//        dfs1.runDFSLoop(false);

//        System.out.println(dfs1.graph.get(new DFSNode(890)));

        HashMap<Integer, Integer> map = new HashMap<>();
//        for (Map.Entry<DFSNode, ArrayList<DFSNode>> entry : dfs1.graph.entrySet()) {
//            DFSNode leaderNode = entry.getKey().leader;
//            if(leaderNode != null) {
//                if (!map.containsKey(leaderNode.value)) {
//                    map.put(leaderNode.value, 1);
//                } else {
//                    int cnt = map.get(leaderNode.value);
//                    map.put(leaderNode.value, ++cnt);
//                }
//            }
//            System.out.println(map);
//        }
//
//        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
//        Collections.sort(list, (o1, o2) -> -Integer.compare(o1.getValue(), o2.getValue()));
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(list.get(i));
//        }

        //867327=32958
        //742933=714
        //725169=626
        //833176=433
        //776760=420
        //814139=412



        bufferedReader.close();
    }

    private static void makeGraph(
            HashMap<DFSNode, ArrayList<DFSNode>> graph,
            ArrayList<DFSNode> list,
            DFSNode start,
            DFSNode end) {

        if(list == null){
            ArrayList<DFSNode> initialList = new ArrayList<>();
            initialList.add(end);
            graph.put(start, initialList);
        }else{
            list.add(end);
            graph.put(start, list);
        }
    }

    static class DFS{
        HashMap<DFSNode, ArrayList<DFSNode>> graph;
        boolean [] visited;

        HashMap<Integer, Integer> leaderCount = new HashMap<>();

        int time = 0;
        DFSNode s = null;

        public DFS(HashMap<DFSNode, ArrayList<DFSNode>> graph){
            this.graph = graph;
            this.visited = new boolean[875715];
        }

        public void runDFS(DFSNode startVertex, boolean isReversed){
            visited[startVertex.value] = true;
//            System.out.println( startVertex.value + " : " + visited[startVertex.value]);

            ArrayList<DFSNode> adjVetices = graph.get(startVertex);
            //System.out.println(adjVetices);

            if(!isReversed) {
                startVertex.setLeader(s);
//                if(!leaderCount.containsKey(s.value)){
//                    leaderCount.put(s.value, 1);
//                }else{
//                    int cnt = leaderCount.get(s.value);
//                    leaderCount.put(s.value, ++cnt);
//                }
            }

            if(adjVetices == null){
                time++;
                startVertex.setFinishTime(time);
                return;
            }

            for (DFSNode v : adjVetices) {
                if (!visited[v.value]) {
                    runDFS(v, isReversed);
                }
            }

            if(isReversed){
                time++;
                startVertex.setFinishTime(time);
            }
        }

        public void runDFSLoop(boolean isReversed){
            if(isReversed) {
                for (Map.Entry<DFSNode, ArrayList<DFSNode>> entry : graph.entrySet()) {
                    DFSNode vertex = entry.getKey();
                    if (!visited[vertex.value]) {
                        runDFS(vertex, true);
                    }
                }
                System.out.println(Arrays.toString(visited));
            }else{
                //int count = 0;
                List<Map.Entry<DFSNode, ArrayList<DFSNode>>> entryList = new LinkedList<>(graph.entrySet());
                Collections.sort(entryList, ((o1, o2) -> Integer.compare(o2.getKey().finishTime, o1.getKey().finishTime)));
                for (Map.Entry<DFSNode, ArrayList<DFSNode>> entry : entryList) {
                    //System.out.println(count++);
                    DFSNode vertex = entry.getKey();
                    if(!visited[vertex.value]){
                        s = vertex;
                        runDFS(vertex, false);
                    }
                }
            }
        }

    }

    static class DFSNode implements Comparable<DFSNode>{
        int value;
        int finishTime;
        DFSNode leader;

        public DFSNode(int value){
            this.value = value;
        }

        public void setFinishTime(int finishTime) {
            this.finishTime = finishTime;
        }

        public void setLeader(DFSNode leader) {
//            System.out.println("setting leader of " + value + " as " + leader.value);
            this.leader = leader;
        }

        @Override
        public int compareTo(DFSNode o) {
            return -Integer.compare(this.finishTime, o.finishTime);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DFSNode dfsNode = (DFSNode) o;
            return value == dfsNode.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            return value + " / leader = " + (leader == null ? null : String.valueOf(leader.value));
        }
    }
}
