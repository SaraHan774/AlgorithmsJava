package com.gahee.algorithms.programmers;

import java.util.Iterator;
import java.util.Stack;

public class Printer {

    public static void main(String[] args) {
        int [] p = {1, 1, 9, 1, 1, 1};
        int l = 0;

        System.out.println(solution(p, l));
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        //작업들의 우선순위가 주어지면, location 번째의 작업의 출력 순서를 반환
        Stack<Integer> stackEnd = new Stack<>();
        Stack<Integer> stackStart = new Stack<>();

        for (int i = 0; i < priorities.length; i++) {
            int cur = priorities[i];

            for (int j = i; j < priorities.length; j++) {
                if(cur < priorities[j]){
                    stackEnd.push(i);
                    break;
                }else{
                    if(j == priorities.length - 1){
                        stackStart.push(i);
                    }
                }
            }
        }

        stackStart.addAll(stackEnd);

        Iterator<Integer> it = stackStart.iterator();
        int idx = 0;
        while(it.hasNext()){
            if(it.next() == location){
                answer = idx;
            }
            ++idx;
        }

        return answer;
    }
}
