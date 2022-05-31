package com.gahee.algorithms.stepbystep.step1;

import java.util.Scanner;

public class Surprise {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        StringBuilder sb = new StringBuilder(s);
        System.out.println(sb.append("??!"));
    }
}
