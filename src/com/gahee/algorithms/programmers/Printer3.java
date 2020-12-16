package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer3 {
    public static void main(String[] args) {
        int [] p = {1, 1, 9, 1, 1, 1};
        int l = 0;

        solution(p, l);
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<>();
        for(int i : priorities){
            que.add(i);
        }

        //큐에다가 우선순위를 담고

        Arrays.sort(priorities);
        //우선순위를 오름차순으로 정렬
        int size = priorities.length-1;

        while(!que.isEmpty()){
            Integer i = que.poll();

            if(i == priorities[size - answer]){
                //우선순위 배열의 마지막과 큐의 i 가 같다면
                answer++;
                //위치를 감소시키고 정답을 증가시킨다
                l--;
                if(l < 0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0) {
                    //내가 찾고자 하는 것의 위치가 맨 뒤로 갔으므로,
                    //맨 뒤의 인덱스로 location 을 초기화 해준다.
                    l = que.size() - 1;
                }
            }
            System.out.println(que);
            System.out.println(l);
        }

        return answer;
    }
}
