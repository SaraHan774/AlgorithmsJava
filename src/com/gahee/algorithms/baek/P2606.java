package com.gahee.algorithms.baek;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 바이러스 문제
 * 연결되어 있는 컴퓨터들끼리 바이러스 감염 위험이 있음.
 * 컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어진다.
 * 1번 컴퓨터가 웜 바이러스에 걸렸을 때,
 * 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
 * */
public class P2606 {

    private static int answer = 0;

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int numComputers = 0;
        int numConnectedPairs;
        ArrayList<Integer>[] graph = new ArrayList[0];

        try{
            numComputers = Integer.parseInt(bufferedReader.readLine());
            numConnectedPairs = Integer.parseInt(bufferedReader.readLine());

            graph = new ArrayList[numComputers + 1];
            ArrayList<Integer> list;
            for (int i = 0; i < numConnectedPairs; i++) {
                line = bufferedReader.readLine();
                String [] s = line.split(" ");
                int r = Integer.parseInt(s[0]);
                int c = Integer.parseInt(s[1]);

                list = graph[r];
                if(list == null){
                    list = new ArrayList<>();
                }
                list.add(c);
                graph[r] = list;

                //양쪽 모두 다 연결해주어야 한다 ... ㅠㅠ
                list = graph[c];
                if(list == null){
                    list = new ArrayList<>();
                }
                list.add(r);
                graph[c] = list;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

//        System.out.println(Arrays.toString(graph));
        boolean [] visited = new boolean[numComputers + 1];

        //do BFS - 연결 되어있는 모든 요소들을 찾아야 함.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = true;
            ArrayList<Integer> nodes = graph[cur];
            if(nodes != null){
                for (int node : nodes) {
                    if(!visited[node]){
                        queue.add(node);
                    }
                }
            }else{
                int next = cur + 1;
                if(next < numComputers) {
                    queue.add(next);
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            if(i == 1){
                continue;
            }
            if(visited[i]) {
//                System.out.println("visited " + i);
                answer++;
            }
        }

        System.out.println(answer);

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
