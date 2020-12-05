package com.gahee.algorithms.programmers;

import java.util.PriorityQueue;

public class Scoville1 {

    public static void main(String[] args) {

        int [] s = {1, 2, 4, 5};
        int k = 10;

        int sol = solution(s, k);
        System.out.println(sol);
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        int answer = 0;

        //make it min heap
        for (int j : scoville) {
            priorityQueue.add(j);
        }

        for (int i = 0; i < scoville.length - 1; i++) {
            int min1 = priorityQueue.poll();
            int min2 = priorityQueue.poll();
            int mix = min1 + min2*2;
            priorityQueue.add(mix);
            ++answer;
            System.out.println(priorityQueue);

            //섞은것이 K 이상이면서 가장 앞의 숫자가 7 이상이면
            // 그 뒤의 모든 숫자들도 K 이상일 것
            if(mix >= K && priorityQueue.peek() >= K){
                return answer;
            }
        }

        return -1 ;
    }
}
