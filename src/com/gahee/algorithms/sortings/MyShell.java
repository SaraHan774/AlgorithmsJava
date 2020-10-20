package com.gahee.algorithms.sortings;

public class MyShell {

    public static void sort(Comparable [] a){
        int N = a.length;
        int h = 1;

        //1, 4, 13, 40 ... 과 같은 숫자 h가 나온다.
        while(h < N / 3){
            h = 3 * h + 1;
        }

        System.out.println("h = " + h);

        while(h >= 1){
            //h = 1 이면 요소간의 간격이 1인것
            for (int i = h; i < N; i++) {

                //기본적으로 삽입정렬과 똑같은데, 무조건 붙어있는 숫자와
                //비교하고 교환하는 것이 아니라, h 라는 간격으로 비교하는 것
                for (int j = i; j >= h && less(a[j], a[j-h]); j-= h) {
                    exchange(a, j, j-h);
                }
                h = h / 3; //간격을 좁혀나간다.
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
