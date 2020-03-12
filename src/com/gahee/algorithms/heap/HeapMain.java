package com.gahee.algorithms.heap;

public class HeapMain {

    public static void main(String[] args) {
//        System.out.println(Math.round(9/2)); //4.5 는 내려서 4가 된다.
        int [] arr = {100,3, 5, 1, 2, 6, 7, 8, 9, 10};

        Heap heap = new Heap();
        int [] ret = heap.heapSort(arr);

        for(int i = 1; i < arr.length; i++){
            System.out.println(ret[i]);
        }
    }
}
