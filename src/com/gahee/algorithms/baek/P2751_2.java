package com.gahee.algorithms.baek;

import java.io.*;
import java.util.PriorityQueue;

public class P2751_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < N; i++) {
            bw.write(priorityQueue.poll().toString() + "\n");
        }
        br.close();
        bw.close();
        }
}
