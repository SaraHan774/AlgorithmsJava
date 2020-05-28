package com.gahee.algorithms.baek;

import java.io.*;
import java.util.Arrays;

public class P1427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] numbers = br.readLine().toCharArray();
        Arrays.sort(numbers);
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
        }
        br.close();
    }
}