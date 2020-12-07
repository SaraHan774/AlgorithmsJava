package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

    public static void main(String[] args) {
        int [][] jobs = {
                {0, 5}, {10, 100}, {200, 9}, {300, 6}
        };
        int [][] jobs2 = {
                {100, 40}, {5, 8}, {6, 9}, {7, 1000}
        };
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        //처리가 빨리 끝나는 작업부터 처리하면 최적의 평균 시간이 나온다.
        //유명한 문제 ...
        int prev = 0;
        int total = 0;

        //하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[1]));

        for (int i = 0; i < jobs.length - 1; i++) {
            int cur = jobs[i][1];
            System.out.println("cur = " + cur);
            int curTime = jobs[i][0];
            int nextTime = jobs[i+1][0];

            System.out.println("time = " + curTime + " / " + nextTime);

            if(curTime > nextTime){
                //작업 처리
                int [] temp = jobs[i];
                System.out.println(Arrays.toString(jobs[i]) + " <=> " + Arrays.toString(jobs[i+1]));
                jobs[i] = jobs[i+1];
                jobs[i+1] = temp;
            }

            total += (prev - jobs[i][0] + cur);
            prev += jobs[i][1];

            System.out.println("total = " + total);
        }
        total += (prev - jobs[jobs.length - 1][0] + jobs[jobs.length - 1][1]);
        //prev += jobs[jobs.length - 1][1];
        System.out.println("cur = " + jobs[jobs.length - 1][0] + ", " + "total = " + total);

        answer = total / (jobs.length);

        return answer;
    }
}
