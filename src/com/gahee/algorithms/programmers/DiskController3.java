package com.gahee.algorithms.programmers;

import java.util.*;

public class DiskController3 {

    public static void main(String[] args) {
        int [][] jobs = {
                {0,3}, {1,9}, {2,6}
        };

        int s = solution(jobs);
        System.out.println(s);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int len = jobs.length;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        Queue<Job> jobQueue = new LinkedList<>();

        for (int i = 0; i < jobs.length; i++) {
            jobQueue.add(new Job(jobs[i][0], jobs[i][1]));
        }

//        System.out.println(jobQueue);
        PriorityQueue<Job> priorityQueue = new PriorityQueue<>();

        int time = 0;

        while(!jobQueue.isEmpty() || !priorityQueue.isEmpty()){

            while(!jobQueue.isEmpty() && time >= jobQueue.peek().reqTime){
                priorityQueue.add(jobQueue.poll());
            }

            if(!priorityQueue.isEmpty()){
                Job curJob = priorityQueue.poll();
                time += curJob.duration;
                answer += (time - curJob.reqTime);
            }else{
                time += 1;
            }
        }

        return answer/len;
    }


    static class Job implements Comparable{
        int reqTime;
        int duration;

        public Job(int reqTime, int duration) {
            this.reqTime = reqTime;
            this.duration = duration;
        }

        @Override
        public int compareTo(Object o) {
            return Integer.compare(this.duration, ((Job)o).duration);
        }

        @Override
        public String toString() {
            return "Job{" +
                    "reqTime=" + reqTime +
                    ", duration=" + duration +
                    '}';
        }
    }
}
