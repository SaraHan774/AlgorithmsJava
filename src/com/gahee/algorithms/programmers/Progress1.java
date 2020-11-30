package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Progress1 {

    public static void main(String[] args) {
        int [] p = {95, 90, 99, 99, 99, 99};
        int [] s = {1, 1, 1, 1, 1, 1};

        System.out.println((int)Math.ceil(((double)100 - (double)68)/30));
        //작업 속도는 100이하의 자연수
        System.out.println("\n\n" + Arrays.toString(solution(p, s)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int [] answer;
        int len = progresses.length;
        answer = new int[len];

        if(len == 1){
            answer = new int[]{1};
            return answer;
        }

        Queue<Integer> queue = new LinkedList<>();
        int idx = 0;

        for (int i = 0; i < progresses.length; i++) {
            int p = progresses[i];
            int s = speeds[i];

            //현재 작업일 cur
            int cur = (int) Math.ceil(((double)100 - p) / s);

            if(queue.peek() != null){
                int top = queue.peek();
                answer[idx] += 1;
                if(top < cur){
                    answer[idx] = queue.size();
                    queue.clear();
                    idx++;
                }
            }
            queue.offer(cur);

            System.out.println(queue);
        }

        answer[idx] = queue.size();

        return Arrays.copyOfRange(answer, 0, idx + 1);
    }
}
