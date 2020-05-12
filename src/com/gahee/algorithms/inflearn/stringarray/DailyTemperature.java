package com.gahee.algorithms.inflearn.stringarray;

import java.util.Stack;

public class DailyTemperature {

    //2개를 비교해야해 - 어딘가에 저장해두어야 한다. Stack 을 사용하자.

    public static void main(String[] args) {

        int [] nums = {73, 74, 75, 71, 69, 72, 76, 73};
        int [] res = dailyTemperatures(nums);

        for (int re : res) {
            System.out.println(re);
        }
    }

    private static int[] dailyTemperatures(int[] nums) {

        // 담을 그릇을 만든다.
        Stack<Integer> stack = new Stack<>();
        int [] result = new int[nums.length];
        //2
        for (int i = 0; i < nums.length; i++) {
            //비교 대상의 값이 나보다 크면 해당 인덱스를 스택에 담는다.
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int index = stack.pop();
                result[index] = i - index;
                // result[0] = 1-0
            }
            stack.push(i); //일단 담아
        }
        return result;
    }
}
