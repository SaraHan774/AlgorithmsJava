package com.gahee.algorithms.baek;

import java.io.*;
import java.util.StringTokenizer;

public class P11654 {

    // 문제:  문자가 들어오면 아스키값으로 출력하라.

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();

        char C = N.toCharArray()[0];
        System.out.println((int) C);

        br.close();
    }
}
