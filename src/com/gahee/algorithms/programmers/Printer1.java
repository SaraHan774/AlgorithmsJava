package com.gahee.algorithms.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Printer1 {

    public static void main(String[] args) {
        int [] p = {3, 2, 1, 5, 1, 2};
        int location = 4;

        System.out.println(solution(p, location));
    }

    public static int solution(int [] priorities, int location){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> list
                = new ArrayList<>(Arrays.stream(priorities)
                .boxed().collect(Collectors.toList()));

        System.out.println(list);
        int len = priorities.length;
        //input 을 배열로
        while(stack.size() < len){
            int i;
            for (i = 0; i < len; i++) {
                int cur = priorities[i];

                for (int j = i + 1; j < len; j++) {
                    int comp = priorities[j];

                    if(cur < comp){
                        //뒤로 옮겨야 할 것을 옮긴다
                        list.remove(i);
                        list.add(cur);
                        break;
                    }
                }
            }
            int out = list.get(0);
            for (int i1 = 0; i1 < priorities.length; i1++) {
                if(out == priorities[i1]){
                    stack.push(i1);
                    priorities[i1] = -1;
                }
            }
        }

        System.out.println(stack);
        return answer;
    }
}