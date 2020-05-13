package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10872 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long fac = factorial(N);
        System.out.println(fac);

        br.close();
    }

    private static long factorial(long n) {
        if(n <= 1) {
            return 1;
        }
        return n * factorial(n-1);
    }
}
