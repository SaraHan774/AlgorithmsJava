package com.gahee.algorithms.stepbystep.step4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class P1546 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTest = scanner.nextInt();

        int max = Integer.MIN_VALUE;
        int [] scores = new int[numTest];

        for (int i = 0; i < numTest; i++) {
            int score = scanner.nextInt();
            scores[i] = score;

            if (score > max) {
                max = score;
            }
        }

//        System.out.println("max = " + max);
//        System.out.println("scores = " + Arrays.toString(scores));

        BigDecimal sum2 = BigDecimal.ZERO;
        for (int i = 0; i < numTest; i++) {
            BigDecimal score2 = calcNewScore(scores[i], max);
//            System.out.println("new score " + i + " => " + score2);
            sum2 = sum2.add(score2);
        }

        BigDecimal avg2 = sum2.divide(new BigDecimal(numTest), 3,RoundingMode.HALF_UP);
        System.out.println(avg2);
    }

    static BigDecimal calcNewScore(int original, int max) {
        BigDecimal o = new BigDecimal(original);
        BigDecimal m = new BigDecimal(max);
        return o.divide(m, 3,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
    }
}
