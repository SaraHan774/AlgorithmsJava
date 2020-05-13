package com.gahee.algorithms.baek;

import java.util.Arrays;
import java.util.Scanner;

public class A2447 {

    static char arr[][];

    public static void star(int a, int b, int n){
        int div;
        if(n == 1){
            arr[a][b] = '*';
            return;
        }
        div = n/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if(i == 1 && j == 1){
                    continue;
                }
                star(a + (div*i), b + (div*j), div);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        arr = new char[n][n];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], ' ');
        }

        star(0, 0, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
