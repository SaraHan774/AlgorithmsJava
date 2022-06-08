package com.gahee.algorithms.stepbystep.step4;

import java.util.Scanner;

public class P8958 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            String line = scanner.next();
            char [] chars = line.toCharArray();

            int consecutive = 0;
            int score = 0;
            for (char aChar : chars) {
                if (aChar == 'O') {
                    consecutive++;
                    score += consecutive;
                } else if (aChar == 'X') {
                    consecutive = 0;
                }
            }
            System.out.println(score);
        }
    }
}
