package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String [] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1.length() > o2.length()){
                return 1;
            }else if(o1.length() == o2.length()){
                return o1.compareTo(o2);
            }else{
                return -1;
            }
        });


        for (int i = 0; i < arr.length; i++) {
            if(i < arr.length - 1 && arr[i].equals(arr[i + 1])){
                continue;
            }else{
                System.out.println(arr[i]);
            }
        }

        br.close();
    }
}
