package com.gahee.algorithms.stepbystep.step2;

import java.util.Scanner;

public class P2525 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int startH = s.nextInt();
        int startM = s.nextInt();
        int duration = s.nextInt();

        int mins  = (startM + duration) % 60;
        int hours = (startM + duration) / 60;

        if (startH + hours >= 24) {
            int endH = (startH + hours) % 24;
            System.out.println(endH + " " + mins);
        } else {
            System.out.println((startH + hours) + " " + mins);
        }
    }
}
