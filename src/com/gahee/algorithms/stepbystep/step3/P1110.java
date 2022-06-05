package com.gahee.algorithms.stepbystep.step3;

import java.util.Scanner;

public class P1110 {

    static int count = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();

        if (a > 99 || a < 0) {
            throw new IllegalStateException();
        }

        checkIsOrigin(a, a);
        System.out.println(count);
    }

    static int[] splitNumIntoArr(int a) {
        int tens, ones;
        if (a < 10) {
            tens = 0;
            ones = a;
        } else {
            tens = a / 10;
            ones = a % (tens * 10);
        }
        return new int[]{tens, ones};
    }

    static int getNewNum(int rightNum, int added) {
        return rightNum * 10 + added;
    }

    static void checkIsOrigin(int origin, int a) {
        count++; // one cycle at the beginning
        int[] arr = splitNumIntoArr(a);
        int added = (arr[0] + arr[1]) % 10;
        int right = arr[1];
        int newNum = getNewNum(right, added);
        if (newNum == origin) return;
        else {
            checkIsOrigin(origin, newNum);
        }
    }

}
