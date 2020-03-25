package com.gahee.algorithms.baek;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Prob9251 {


    public static void main(String[] args) throws IOException {

        int [][] lcs;

        Scanner scanner = new Scanner(System.in);
        String l1 = scanner.nextLine();
        String l2 = scanner.nextLine();
        scanner.close();

        char [] c1 = l1.toCharArray();
        char [] c2 = l2.toCharArray();

        lcs = new int[c1.length + 1][c2.length + 1];
        for (int i = 0; i < c1.length; i++) {
            lcs[i][0] = 0;
        }
        for (int i = 0; i < c2.length; i++) {
            lcs[0][i] = 0;
        }

        for (int i = 1; i <= c1.length; i++) {

            for (int j = 1; j <= c2.length; j++) {
                //만약 c1 에 대해 c2 의 문자가 같다면
                if(c1[i-1] == c2[j-1]){
                        lcs[i][j] = lcs[i-1][j-1]+1;
                }else{
                    //만약 다르다면
                        if(lcs[i-1][j] > lcs[i][j-1]){
                            lcs[i][j] = lcs[i-1][j];
                        }else{
                            lcs[i][j] = lcs[i][j-1];
                    }
                }
            }
        }

        System.out.println(lcs[c1.length][c2.length]);

        for (int i = 0; i <= c1.length; i++) {

            for (int j = 0; j <= c2.length; j++) {
                System.out.print(lcs[i][j] + " ");
            }
            System.out.println("\n");
        }

    }
}
