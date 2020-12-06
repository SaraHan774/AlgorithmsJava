package com.gahee.algorithms.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck1 {

    public static void main(String[] args) {
        int b = 2;
        int w = 10;
        int [] t = {10};
        int [] t2 = {7, 4, 5, 6};

        System.out.println(solution(b, w, t2));
    }

    public static int solution(
            int bridge_length, int weight, int[] truck_weights
    ) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> going = new LinkedList<>();


        for (int i = 0; i < truck_weights.length; i++) {
            queue.add(truck_weights[i]);
        }
        //total weight < weight 인지?
            //한꺼번에 다 올릴수가 없음
        while (!queue.isEmpty()) {
            int total = 0;
            while (!queue.isEmpty()) {
                int t = queue.peek();
                total += t;
                if (total <= weight && going.size() < bridge_length) {
                    going.add(queue.poll());
                    //다리 위에 올라갈때 마다 1초 증가
                    answer++;
                } else {
                    break;
                }
            }

            System.out.println(going);

            //TODO : 지나갈 것들을 골라 둔 후에 작업이 필요함 ...
            while(!going.isEmpty()){
                going.poll();
            }
        }

        return answer;
    }
}
