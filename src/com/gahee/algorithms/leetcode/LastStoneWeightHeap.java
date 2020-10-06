package com.gahee.algorithms.leetcode;

import java.util.PriorityQueue;

public class LastStoneWeightHeap {

    public static void main(String[] args) {

        int [] stones = {2, 7, 4, 1, 8, 1};
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        int result = 0;
        while(maxHeap.size() > 0){
            result = lastStoneWeight(maxHeap);
        }

        System.out.println(result);
    }

    private static int lastStoneWeight(PriorityQueue<Integer> heap){
        if(heap.size() == 1){
            return heap.poll();
        }
        int first = heap.poll();
        int second = heap.poll();

        int smashed;

        if(first > second || first < second){
            smashed = first - second;
            heap.offer(Math.abs(smashed));
        }
        return 0;
    }

}
