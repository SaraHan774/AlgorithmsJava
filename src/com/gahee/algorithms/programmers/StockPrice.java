package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.Stack;

public class StockPrice {


    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 2, 3};

        int [] ans = solution(arr);
        System.out.println(Arrays.toString(ans));
    }


    public static int[] solution(int[] prices) {
        int[] answer;
        answer = new int[prices.length];

        Stack<Integer> beginIdx = new Stack<>();
        int i = 0;

        beginIdx.push(i); //최초의 인덱스 푸시

        for(i = 1; i < prices.length; i++){
            System.out.println("current price : " + prices[i]);
            //가격을 순회하면서
            //인덱스가 비어있지 않은 동안, 현재 가격과 이전의 가격을 비교
            while(!beginIdx.empty() && prices[i] < prices[beginIdx.peek()]){
                System.out.println(prices[i] + " < " + prices[beginIdx.peek()]);
                //만약 현재 가격이 낮다면
                //이전의 인덱스를 꺼내서
                //현재 인덱스의 값에서 빼어서 다시 할당한다.
                int begin = beginIdx.pop();
                answer[begin] = i - begin;
                System.out.println(Arrays.toString(answer));
            }
            //만약 현재 가격이 더 높다면 현재 인덱스를 푸시한다.
            beginIdx.push(i);
            System.out.println("begin Idxs : " + beginIdx);
        }
        //스택이 비어있지 않은 동안
        while(!beginIdx.empty()){
            //인덱스를 pop 해서 answer 의 값들을 빼줌
            int begin = beginIdx.pop();
            answer[begin] = i - begin - 1;
            System.out.println(Arrays.toString(answer));
        }
        return answer;
    }
}
