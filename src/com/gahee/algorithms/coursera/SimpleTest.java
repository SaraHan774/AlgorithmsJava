package com.gahee.algorithms.coursera;

import java.util.Arrays;
import java.util.HashSet;

public class SimpleTest {

    public static void main(String[] args) {
        int [] arr = new int[100];

        //배열을 함수의 인자값으로 넘긴 후
        //100 까지 숫자를 넣어서 배열을 변경시킨다.
        helloArray(arr);

        //변경된 배열 상태로 출력된다.
        //System.out.println(Arrays.toString(arr));

        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        set1.add("a");
        set1.add("b");

        set2.add("b");
        set2.add("a");
        System.out.println(set1.equals(set2));
    }

    private static void helloArray(int[] arr) {
        for (int i = 0; i < 100; i++) {
            arr[i] = i;
        }
    }
}
