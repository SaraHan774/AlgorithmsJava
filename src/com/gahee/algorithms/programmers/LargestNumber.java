package com.gahee.algorithms.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class LargestNumber {

    public static void main(String[] args) {
        //0또는 양의 정수
        //정수를 이어 붙여서 만들수 있는 가장 큰 수
        //0 또는 양의 정수가 담긴 배열이 주어짐
        //문자열로 가장 큰 수 리턴
        //numbers 길이 1 ~ 100,000 이하
        //원소는 0 ~ 1000 이하

        int [] nums = {0, 0, 0};
        int [] nums2 = {3, 30, 34, 5, 9};

        System.out.println(solution(nums));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String zero = "";
        PriorityQueue<String> strings = new PriorityQueue<>((o1, o2) -> {
            char a = o1.charAt(0);
            char b = o2.charAt(0);
            if(a != b){
                return -Character.compare(a, b);
            } else{
                String a1 = o1.concat(o2);
                String a2 = o2.concat(o1);
                return -Integer.compare(Integer.parseInt(a1), Integer.parseInt(a2));
            }
        });
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] != 0){
                strings.add(Integer.toString(numbers[i]));
            }else{
                zero = zero.concat("0");
            }
        }

        while(!strings.isEmpty()){
            answer = answer.concat(strings.poll());
        }

        if(!answer.equals("")){
            answer = answer.concat(zero);
        }else{
            answer = "0";
        }

        return answer;
    }
}
