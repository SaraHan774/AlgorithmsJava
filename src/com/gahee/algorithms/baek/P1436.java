package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        int dummy = 666;
        String n = "";
        while(count < N) {
            n = String.valueOf(dummy);
            if (n.contains("666")) {
                count++;
            }
            dummy++;
        }
        System.out.println(n);
    }
}
