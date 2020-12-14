package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HIndex {

    public static void main(String[] args) {
        int [] t = {0, 0, 0, 1, 5, 6};
        System.out.println(solution(t));
    }

    public static int solution(int [] citations){
        int answer = 0;

        int [] k = new int[10000];
        //citations 1 ~ 1000
        Arrays.sort(citations);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> Integer.compare(o2, o1)
        );

        for (int i = 0; i < citations.length; i++) {
            int c = citations[i];
            if(k[c] != 0){
                continue;
            }
            k[c]++;
            for (int j = i + 1; j < citations.length; j++) {

                if(c <= citations[j]){
                    k[c]++;
                }
            }
            if (c <= k[c]) {
                priorityQueue.offer(c);
            }
        }

        if(!priorityQueue.isEmpty()){
            answer = priorityQueue.poll();
        }
        return answer;
    }
}
