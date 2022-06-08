package com.gahee.algorithms.stepbystep.step4;

import java.util.Arrays;
import java.util.Scanner;

public class P10818 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
//        int [] arr = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
//            arr[i] = s.nextInt();
            int k = s.nextInt();
            if (k < min) {
                min = k;
            }
            if (k > max) {
                max = k;
            }
        }
        System.out.println(min);
        System.out.println(max);
//        Arrays.stream(arr).min().ifPresent(System.out::println);
//        Arrays.stream(arr).max().ifPresent(System.out::println);
    }
}
