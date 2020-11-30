package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.Stack;

public class Progress {

    public static void main(String[] args) {
        int [] p = {93, 30, 55};
        int [] s = {1, 30, 5};
        System.out.println(Arrays.toString(solution(p, s)));
    }

    public static int [] solution(int [] progress, int [] speeds){
        int [] answer = new int[100];
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push((100 - progress[0]) / speeds[0]); //초기값
        for (int i = 1; i < progress.length; i++) {
            int day = (100 - progress[i]) / speeds[i];
            if(stack.peek() < day) {
                answer[idx] = stack.size();
                idx += 1;
                while (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            stack.push(day); //스택에 넣기
            //System.out.println(stack);
            if(i == progress.length - 1){
                answer[idx] = stack.size();
            }
        }
        return Arrays.copyOfRange(answer, 0, idx + 1);
    }
}
