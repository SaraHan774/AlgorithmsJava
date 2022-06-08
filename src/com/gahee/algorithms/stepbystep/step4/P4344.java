package com.gahee.algorithms.stepbystep.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class P4344 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        NumberFormat df = DecimalFormat.getInstance();
        df.setMinimumFractionDigits(3);
        df.setMaximumFractionDigits(3);

        for (int i = 0; i < t; i++) {
            String[] line = br.readLine().split(" ");
            int numStudents = Integer.parseInt(line[0]);
            int sum = 0;
            double avg;
            int[] scores = new int[numStudents];

            // TODO : watch out for this !
            for (int j = 0; j < numStudents; j++) {
                int score = Integer.parseInt(line[j + 1]);
                scores[j] = score;
                sum += score;
            }

            avg = (double) sum / numStudents;
            int above = 0;

            for (int score : scores) {
                if (score > avg) {
                    above++;
                }
            }
            String result = df.format(((double) above / numStudents) * 100);
            System.out.println(result + "%");
        }
    }
}
