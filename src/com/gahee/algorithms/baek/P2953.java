package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        final int PARTICIPANTS = 5;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < PARTICIPANTS; i++) {
            st = new StringTokenizer(br.readLine());
            int totalScore = 20;
            while(st.hasMoreTokens()){
                int s = Integer.parseInt(st.nextToken());
                totalScore -= s;
            }
            priorityQueue.offer(totalScore);
            hashMap.put(totalScore, i);
        }
        int s=0;
        if(!priorityQueue.isEmpty()){
            s = priorityQueue.poll();
        }

        int idx = hashMap.get(s);
        System.out.print((idx + 1) + " " + (20 - s));
    }
}
