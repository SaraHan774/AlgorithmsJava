package com.gahee.algorithms.stepbystep.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int x = Integer.parseInt(arr[1]);
        String [] arr2 = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(arr2[i]);
            if (a < x) {
                System.out.print(a);
                System.out.print(" ");
            }
        }
    }
}
