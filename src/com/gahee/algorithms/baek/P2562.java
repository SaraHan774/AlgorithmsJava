package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.

예를 들어, 서로 다른 9개의 자연수

3, 29, 38, 12, 57, 74, 40, 85, 61

이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
* */
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
        //숫자가 들어올때마다 힙을 만든다?
        //숫자를 받으면서 max 를 확인하고 -> 0N 인덱스를 출력한다?
        br.close();
    }
}
