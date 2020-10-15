package com.gahee.algorithms.sortings;

public class Selection {

    public static void sort(Comparable [] a){

        int idx = 0;
        for (int i = idx + 1; i < a.length; i++) {

        }
    }

    private static void exchange(Comparable[] a, int idx, int i) {
        Comparable sub = a[idx];
        a[idx] = a[i];
        a[i] = sub;
    }
}
