package com.gahee.algorithms.programmers;

import java.util.Arrays;

public class TargetNumber {


    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int answer = s.solution(nums, target);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(int[] numbers, int target) {
            int answer = 0;

            answer = bfs(numbers, target, numbers[0], 1) + bfs(numbers, target, -numbers[0], 1);
            return answer;
        }

        public int bfs(int[] numbers, int target, int sum, int i) {
            System.out.println("i = " + i + ", sum = " + sum);
            if(i == numbers.length) {
                if(sum == target) {
                    System.out.println("sum == target =>" + sum);
                    return 1;
                } else {
                    System.out.println("sum != target =>" + sum);
                    return 0;
                }
            }
            int result = 0;
            result += bfs(numbers, target, sum+numbers[i], i+1);
            result += bfs(numbers, target, sum-numbers[i], i+1);
            System.out.println(result);
            return result;
        }
    }
}
