package com.gahee.algorithms.scofe2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class House {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int N = Integer.parseInt(input);

        int [][] h = new int[N][N];

        int one = 0;
        for (int i = 0; i < N; i++) {
            char [] l = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                h[i][j] = Character.getNumericValue(l[j]);
                if(h[i][j] == 1){ one++; }
            }
        }

        int k = 1; //간격
        int [] count = new int[N];
        count[0] = one;
        int total = 0;
        total += one;
        while(k < N){
            System.out.println("k = " + k);
            for (int i = 0; i < N - k; i++) { //0,0 ~ 2,2
                for (int j = 0; j < N - k; j++) {
                    int start = h[i][j];

                    System.out.println("start = " + i +", " + j + "\n");

                    int l, m;
                    for (l = i; l <= k + i; l++) { //i,j ~ k,k
                        boolean isInvalid = false;
                        for (m = j; m <= k + j; m++) {
                            System.out.println("checking = " + l +", " + m);
                            if(h[l][m] == 0){
                                isInvalid = true;
                                break;
                            }
                        }
                        if(isInvalid){
                            System.out.println("invalid, break");
                            break;
                        }else if(l == k + i){
                            count[k]++;
                            total++;
                        }
                    }
                }
            }
            k++; //간격 증가
        }
        System.out.println("total: " + total);
        for (int i = 0; i < count.length; i++) {
            if(count[i] == 0){break;}
            System.out.println("size["+(i+1)+"]: " + count[i]);
        }

    }
}
