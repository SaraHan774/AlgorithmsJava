package com.gahee.algorithms.sortings;

public class MySelection {

    public static void sort(Comparable [] a){

        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i; //현재까지 찾은 가장 작은 항목에 대한 인덱스
            for (int j = i + 1; j < N; j++) {
                if(less(a[j], a[min])){
                    min = j;
                }
                exchange(a, i, min);
            }
        }
    }

    private static void exchange(Comparable[] a, int i, int min) {
        Comparable sub = a[i];
        a[i] = a[min];
        a[min] = sub;
    }

    private static boolean less(Comparable comparable, Comparable comparable1) {
        if(comparable.compareTo(comparable1) < 0){
            return true;
        }
        return false;
    }

}
