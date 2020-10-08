package com.gahee.algorithms.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class NRepeated {

    public static void main(String[] args) {


        int [] A = {5, 1, 5, 2, 5, 3, 5, 4, 6, 6, 6, 6, 6, 1, 1, 1, 1, 1, 1};

        int result = repeatedNTimesHash(A);
        System.out.println(result);
    }
    //length 4이상 1만 미만
    //A[i] 는 0 이상 10000미만
    //A의 길이는 짝수이다.

    //특정 요소가 몇번 반복될지를 알수있음
    //카운팅 배열을 만들어서 해당 반복 인덱스의 숫자를 반환?
    private static int repeatedNTimes(int[] A) {
        int N = A.length;
        int [] counting = new int[10000];

        int max = -1;
        int maxIdx = 0;

        for (int i = 0; i < N; i++) {
            int idx = A[i];
            counting[idx] += 1;

            if(counting[idx] > max){
                max = counting[idx];
                maxIdx = idx;
            }
        }
        return maxIdx;
    }

    private static int repeatedNTimesHash(int [] A){
        HashSet<Integer> hashSet = new HashSet<>();

        for (int value : A) {
            if (hashSet.contains(value)) {
                return value;
            } else {
                hashSet.add(value);
            }
        }
        return 0;
    }
}
