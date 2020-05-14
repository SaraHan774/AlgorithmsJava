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
//                System.out.printf("star(%d, %d, %d)\n", a + (div*i), b+(div*j), div);
                // div * i 와 같이 출력하므로 i == j == 1 일때 즉, 3,3,3 와 같은 경우엔
                // 별이 출력되지 않는다.
                star(a + (div*i), b + (div*j), div);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        arr = new char[n][n];

        for (int i = 0; i < arr.length; i++) {
            //각 행을 돌면서 i 번째 행의 모든 열을 빈 문자로 채운다.
            Arrays.fill(arr[i], ' ');
        }

        star(0, 0, n);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
