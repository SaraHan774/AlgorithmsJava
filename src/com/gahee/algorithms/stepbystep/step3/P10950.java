package com.gahee.algorithms.stepbystep.step3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10950 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String [] arr = br.readLine().split("\\s+");
            System.out.println(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
        }
    }
}
