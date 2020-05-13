package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10870 {

    public static void main(String[] args) throws IOException {

        // 0 과 1 로 시작
        // 0 번째 피보나치 수는 0, 1번째는 1 , 그다음은 두 수의 합
        // n 에 대한 피보나치 합을 구하자 (n <= 20)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long fib = fibonacci(N);
        System.out.println(fib);

        br.close();
    }

    private static long fibonacci(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
