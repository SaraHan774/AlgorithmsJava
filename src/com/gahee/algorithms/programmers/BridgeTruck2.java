package com.gahee.algorithms.programmers;

import java.util.*;

public class BridgeTruck2 {


    public static void main(String[] args) {
        int b = 100;
        int w = 100;
        int [] tw = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(b, w, tw));
    }

    public static int solution(
            int bridge_length, int weight, int[] truck_weights
    ) {
        int answer = 0;

        Integer [] arr = new Integer[bridge_length];
        Arrays.fill(arr, 0);

        //큐의 길이를 bridge length 로 제한
        Deque<Integer> bridegQueue  = new LinkedList<>(Arrays.asList(arr));
        Queue<Integer> trucks = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            trucks.add(truck_weights[i]);
        }

        int total = 0;

        while(!trucks.isEmpty()){
            int k = bridegQueue.poll();
            total -= k;

            int cur = trucks.peek();

            if(total + cur <= weight){
                bridegQueue.add(trucks.poll());
                total += cur;
            }else{
                bridegQueue.add(0);
            }
            answer++;
        }

        Iterator<Integer> iterator = bridegQueue.descendingIterator();

        int idx = bridegQueue.size();
        while(iterator.hasNext()){
            if(iterator.next() > 0){
                break;
            }
            idx--;
        }
        answer += idx;

        return answer;
    }
}
