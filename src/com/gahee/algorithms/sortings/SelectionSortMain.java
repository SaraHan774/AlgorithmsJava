package com.gahee.algorithms.sortings;

import java.util.Arrays;

public class SelectionSortMain {

    public static void main(String[] args) {

        String [] strings = {"s", "s", "t", "s", "q"};

        MySelection selection = new MySelection();
        selection.sort(strings);

        System.out.println(Arrays.toString(strings));
    }
}
