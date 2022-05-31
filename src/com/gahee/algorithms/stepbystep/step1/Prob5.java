package com.gahee.algorithms.stepbystep.step1;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Prob5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        float a = s.nextFloat();
        float b = s.nextFloat();
        NumberFormat numberFormat = DecimalFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_EVEN);
        System.out.println(numberFormat.format(a/b));
    }
}
