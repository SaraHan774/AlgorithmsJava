package com.gahee.algorithms.programmers;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Printer2 {

    public static void main(String[] args) {

        int [] p = {2, 1, 3, 2};
        int l = 2;

        int [] p1 = {1, 1, 9, 1, 1, 1};
        int l1 = 0;

        System.out.println(solution(p, l ) == 1);
        System.out.println(solution(p1, l1) == 5);
    }

    public static int solution(int [] priorities, int location){
        int answer = 0;

        Queue<Job> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Job(priorities[i], i));
        }

        Job [] jobOrderArr = new Job[priorities.length];
        int idx = 0;
        while(!queue.isEmpty()){
            Job job = queue.poll();
            Iterator<Job> it = queue.iterator();
            boolean flag = false;
            while(it.hasNext()){
                if(it.next().priority > job.priority){
                    queue.add(job);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                jobOrderArr[idx++] = job;
            }
        }
//        System.out.println(Arrays.toString(jobOrderArr));
        for (int i = 0; i < jobOrderArr.length; i++) {
            if(jobOrderArr[i].location == location){
                answer = i+1;
                break;
            }
        }
//        System.out.println(answer);
        return answer;
    }

    static class Job{
        int priority;
        int location;
        public Job(int p, int l){
            priority = p;
            location = l;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "priority=" + priority +
                    ", location=" + location +
                    '}';
        }
    }
}
