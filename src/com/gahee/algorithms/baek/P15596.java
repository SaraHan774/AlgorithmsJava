package com.gahee.algorithms.baek;

public class P15596 {

    public static void main(String[] args) {

    }

    public static long sum(int [] a){
        long result = 0;

        if(a.length == 0){
            return 0;
        }

        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }

        return result;
    }
}
