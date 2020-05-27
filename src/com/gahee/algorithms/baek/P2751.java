package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2751 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //implement merge sort
        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.sort(0, arr.length - 1, arr);
        mergeSort.printSortedArray();

        br.close();
    }


}

class MergeSort{

    int [] arr;
    int [] sortedArray;

    public MergeSort(int [] arr){
        this.arr = arr;
        this.sortedArray = new int[arr.length];
    }

    public void merge(int low, int mid, int high, int [] array){
        int i, j, k;
        i = low;
        j = mid + 1;
        k = low;
//        System.out.println("merging ... ");
        while(i <= mid && j <= high){
            if(array[i] <= array[j]){
                sortedArray[k++] = array[i++];
            }else{
                sortedArray[k++] = array[j++];
            }
        }

        if(i > mid){
            for (int l = j; l <= high; l++) {
                sortedArray[k++] = array[l]; 
            }
        }else{
            for (int l = i; l <= mid; l++) {
                sortedArray[k++] = array[l];
            }
        }

        for (int l = low; l <= high; l++) {
            array[l] = sortedArray[l];
        }
    }

    public void sort(int low, int high, int [] array){
        int mid;
        if(low < high){
            mid = (low + high)/2;
//            System.out.printf("low : %s mid : %s high : %s", low, mid, high);
//            System.out.println();
            sort(low, mid, array);
            sort(mid+1, high, array);
            merge(low, mid, high, array);
        }
//        System.out.println("low >= high");
//        System.out.printf("low : %s high : %s", low, high);
//        System.out.println();
    }

    public void printSortedArray(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
