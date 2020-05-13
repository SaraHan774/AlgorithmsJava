package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2908 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sbA = new StringBuilder(st.nextToken());
        StringBuilder sbB = new StringBuilder(st.nextToken());
        int A = Integer.parseInt(sbA.reverse().toString());
        int B = Integer.parseInt(sbB.reverse().toString());

        System.out.println(Math.max(A, B));

        br.close();
    }

}
