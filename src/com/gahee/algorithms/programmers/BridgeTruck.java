package com.gahee.algorithms.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {

    public static void main(String[] args) {
        int bl = 2;
        int w = 10;
        int [] tw = {7, 4, 5, 6};

        System.out.println(solution(bl, w, tw));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            int weightSum = 0 ;
            int maxIdx = i;

            while(weightSum <= weight  && maxIdx < truck_weights.length){
                weightSum += truck_weights[maxIdx];
                queue.offer(truck_weights[maxIdx]);
                answer++;
                maxIdx++;
            }
            //out of while loop

            for (int j = 0; j < bridge_length - 1; j++) {
                if(j == bridge_length - 1){
                    queue.poll();
                    break;
                }
                answer++;
            }
        }

        return answer;
    }
}
