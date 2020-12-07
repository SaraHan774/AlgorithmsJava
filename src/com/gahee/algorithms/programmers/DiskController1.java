package com.gahee.algorithms.programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController1 {

    public static void main(String[] args) {
        int [][] jobs = {
                {0, 5}, {10, 100}, {200, 9}, {300, 6}
        };
        int [][] jobs2 = {
                {100, 40}, {5, 8}, {6, 9}, {7, 1000}
        };
        System.out.println(solution(jobs2));
    }

    public static int solution(int [][] jobs){
        int answer = 0;

        PriorityQueue<DiskJob> reqQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.consume));

        for (int i = 0; i < jobs.length; i++) {
            reqQueue.offer(new DiskJob(jobs[i][0], jobs[i][1], i));
            System.out.println(reqQueue);
        }


        return answer;
    }

    private static class DiskJob{
        int req;
        int consume;
        int order;

        public DiskJob(int req, int consume, int order) {
            this.req = req;
            this.consume = consume;
            this.order = order;
        }

        @Override
        public String toString() {
            return "{" +
                    "req=" + req +
                    ", consume=" + consume +
                    ", order=" + order +
                    "}\n";
        }
    }
}
