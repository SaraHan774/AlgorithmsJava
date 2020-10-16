package com.gahee.algorithms.sortings;

public class MyInsertion {

    public static void sort(Comparable [] a){
        int N = a.length;

        //가장 왼쪽의 요소부터 시작해서
        //왼쪽 + 1 의 요소와 크기를 비교한다.
        //작으면 순서를 바꾼다.
        for (int i = 1; i < N; i++) { //오른쪽으로 증가하는 것 표현
            for (int j = i; j > 0 && less(a[i], a[j-1]); j--) {
                //왼쪽으로 가면서 비교하는 것 표현
                exchange(a, j, j - 1);
            }
        }
    }

    private static void exchange(Comparable[] a, int j, int i) {
        Comparable sub = a[j];
        a[j] = a[i];
        a[i] = sub;
    }

    private static boolean less(Comparable comparable, Comparable comparable1) {
        if(comparable.compareTo(comparable1) < 0){
            return true;
        }
        return false;
    }
}
