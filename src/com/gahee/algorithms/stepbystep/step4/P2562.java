package com.gahee.algorithms.stepbystep.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class P2562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((integer, t1) -> -Integer.compare(integer, t1));
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            priorityQueue.offer(num);
            map.put(num, i+1);
        }

        int max = priorityQueue.poll();
        System.out.println(max);
        System.out.println(map.get(max));
        br.close();
    }
}
