package com.gahee.algorithms.programmers;

import java.util.PriorityQueue;

public class Scoville {

    public static void main(String[] args) {

    }

    public static int solution(int[] scoville, int K) {
        int answer = -1;

        //모두 다 K 보다 큰지 확인하는 방법 ?
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }
        priorityQueue.add(K);

        for (int i = 0; i < scoville.length - 1; i++) {
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            if(first == K){
                answer = i + 1;
                break;
            }
            priorityQueue.add(first + second);
        }

        return answer;
    }
}
