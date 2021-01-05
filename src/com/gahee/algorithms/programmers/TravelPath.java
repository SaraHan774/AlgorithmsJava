package com.gahee.algorithms.programmers;

import java.util.*;

/*
* 여행 경로 짜기
* 항상 ICN 공항에서 출발한다.
* 항공권 정보가 담긴 2차원 배열 tickets 가 매개변수로 주어진다.
* 방문하는 공항 경로를 배열에 담아 return
* === 제한사항 ===
* 모든 공항은 알파벳 대문자 3글자, 공항 수는 3 ~ 10,000
* tickets [a,b] => a 에서 b 로 가는 항공권이 있다는 뜻.
* 주어진 항공권은 모두 사용해야 함.
* 가능한 경로가 2개 이상일 경우 알파벳 순서가 앞서는 경로를 리턴 (순서유지)
* 모든 도시를 방문할 수 없는 경우는 주어지지 않는다.
* */
public class TravelPath {

    public static void main(String[] args) {
        String [][] test1 = {
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL","SFO"}
        };

        String [][] test2 = {
                {"ICN", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SOF"},
                {"ABC", "SOF"},
                {"ICN", "ABC"},
        };

        String [] ans = solution(test1);
        System.out.println(Arrays.toString(ans));
    }

    public static String[] solution(String[][] tickets) {
        int numTickets = tickets.length;
        String[] answer;

        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        ArrayList<String> list;
        //2D 배열인 경우에도 for each 로 처리할 수 있다.
        //build graph
        for (String[] ticket : tickets) {
            String s = ticket[0];
            String t = ticket[1];

            list = graph.get(s);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(t);
            Collections.sort(list);
            graph.put(s, list);
        }
        System.out.println(graph);

        //do dfs - 사이클 허용해야 함.
        ArrayList<String> visited = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        ticketsDFS(graph, "ICN", visited, numTickets, stack);


        answer = new String[visited.size()];
        for (int i = 0; i < visited.size(); i++) {
            answer[i] = visited.get(i);
        }

        return answer;
    }

    private static void ticketsDFS(
            HashMap<String, ArrayList<String>> graph,
            String start,
            ArrayList<String> visited,
            int total,
            Stack<String> stack){

        if(visited.size() > total){
            return;
        }

        stack.push(start);

        while(!stack.isEmpty()){
            String s = stack.pop();
            visited.add(s);
            System.out.println("visited = " + s);

            ArrayList<String> list = graph.get(s);
            if(list == null || list.isEmpty()){ continue; }

            for (String s1 : list) {
                ArrayList<String> newList = new ArrayList<>(list);
                newList.remove(s1);

                graph.put(s, newList);
                ticketsDFS(graph, s1, visited, total, stack);
            }
        }
    }
}
