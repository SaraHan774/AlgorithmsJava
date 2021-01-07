package com.gahee.algorithms.programmers;

import java.util.Arrays;

public class NTimesArray {

    public static void main(String[] args) {

        long [] ans = solution(2, 5);
        System.out.println(Arrays.toString(ans));
    }

    public static long[] solution(int x, int n) {
        long[] answer = new long[n + 1];

        for (int i = 1; i < n + 1; i++) {
            // long 배열에 담을때는 long 으로 타입 캐스팅 해주기.
            answer[i] = (long) x *i;
        }
        answer = Arrays.copyOfRange(answer, 1, n+1);
        return answer;
    }
}
