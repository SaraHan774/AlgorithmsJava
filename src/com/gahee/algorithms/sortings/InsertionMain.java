package com.gahee.algorithms.sortings;

import java.util.Arrays;

public class InsertionMain {

    public static void main(String[] args) {

//        MyInsertion insertion = new MyInsertion();
        String [] strings = {"avc", "brgr", "qqqq", "xcv", "ntgbr", "asd"};
//        insertion.sort(strings);
//        System.out.println(Arrays.toString(strings));
//
        MyShell myShell = new MyShell();
        myShell.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
