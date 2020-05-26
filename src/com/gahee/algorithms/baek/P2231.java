package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //N의 가장 작은 생성자를 구하라.
        int minSum = Integer.MAX_VALUE;

        // N-1 부터 시작해서 0일때까지 숫자를 비교한다.
        for (int i = N-1; i >= 0 ; i--) {
            String n = Integer.toString(i);
            int nsum = 0;
            char [] narr = n.toCharArray();
            // i 라는 숫자를 char array 로 변형하여 각 자리수를 더한다.
            for (char c : narr) {
                nsum += (c - 48); // char -> int 를 위해 48을 빼준다.
            }
            // 자릿수를 다 더하면 i 자체를 합해준다.
            nsum += i;
            // i 와 i 의 각 자릿수를 합한 결과가 N과 같은지 비교한다.
            if(nsum == N){
                //만약 같다면 최소값을 찾기 위해 minSum 을 업데이트 한다.
                if(minSum >= i){
                    minSum = i;
                }
            }
        }
        // 만약 minSum 이 업데이트 되지 않았다면 0을 출력한다.
        if (minSum == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            // 최소 생성자를 찾았다면 해당 숫자를 출력한다.
            System.out.println(minSum);
        }
        br.close();
    }
}
