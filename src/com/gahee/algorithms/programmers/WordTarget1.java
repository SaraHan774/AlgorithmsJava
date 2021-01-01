package com.gahee.algorithms.programmers;

import javax.sound.sampled.Line;
import java.util.*;

public class WordTarget1 {

    public static void main(String[] args) {
        String [] words = {"hot", "dot", "dog", "lot", "log", "cog", "mam", "jam", "cat", "tac", "hat", "hht", "hih"};
        String [] test2 = {"hhh", "hht", "hih"};
        String [] test3 = {"aaaa", "abaa", "abaa"};
        String begin = "abca";
        String target = "abaa";

        int answer = solution(begin, target, test3);
        System.out.println(answer);
    }

    public static int solution(String begin, String target, String [] words){
        int answer = 0;
        int len = begin.length();
        //word 의 길이 length 로 유지하기
        //양방향 그래프,
        boolean isValidTarget = false;
        for (String word : words) {
            if (target.equals(word)) {
                isValidTarget = true;
                break;
            }
        }
        //유효한 타겟인지 검사한 후 아니라면 0을 반환한다.
        if(!isValidTarget){
            return answer;
        }

        String [] words2 = new String[words.length + 1];
        words2[0] = begin;
        for (int i = 0; i < words.length; i++) {
            words2[i+1] = words[i];
        }

//        ArrayList<String> [] graph = new ArrayList[words2.length];
        LinkedHashMap<String, ArrayList<String>> graph = new LinkedHashMap<>(words2.length);

        for (int i = 0; i < words2.length; i++) {
            String cur  = words2[i];
            ArrayList<String> list = new ArrayList<>();
            for (int j = 0; j < words2.length; j++) {
                char [] curArr = cur.toCharArray();
                char [] compArr = words2[j].toCharArray();
                if(i == j){ continue; }
//                System.out.println("comparing " + cur + " vs. " + words2[j]);
                //두 단어를 비교해서 len - 1 개의 철자와 위치가 같다면 노드 연결
                int count = 0;
                for (int k = 0; k < len; k++) {
                    if(curArr[k] == compArr[k]){
                        count++;
                    }
                }
                //만약 두 개 이상의 철자와 위치가 같다면 인접 리스트에 연결한다.
                if(count >= len-1){
                    list.add(words2[j]);
                }
            }
            graph.put(words2[i], list);
        }
        System.out.println(graph);

        //do bfs
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> visited = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();

        queue.add(begin);
        count.put(begin, 0);

        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(visited.contains(cur)){
               continue;
            }
            visited.add(cur);
            System.out.println("visited " + cur);
            ArrayList<String> nodes = graph.get(cur);
            if(nodes == null){
                continue;
            }
            for (String node : nodes) {

                if(!visited.contains(node)){
                    queue.add(node);
//                    System.out.println("scanning " + node);
                    int curCount = count.get(cur) + 1;
                    count.put(node, curCount);
                    System.out.println(count);
                    if(node.equals(target)){
                        answer = count.get(node);
//                        System.out.println(answer);
                        return answer;
                    }
                }
            }
        }
        return answer;
    }


}
