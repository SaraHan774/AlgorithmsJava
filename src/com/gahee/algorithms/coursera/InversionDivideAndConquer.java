package com.gahee.algorithms.coursera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class InversionDivideAndConquer {
    static BigInteger inversion = BigInteger.valueOf(0);
    static int [] sortedArr = new int[1000001];
    static int [] arr;

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> arrayList = new ArrayList<>();

        File file =
                new File("C:\\Users\\sarah\\Desktop\\2020\\Algorithms\\src\\com\\gahee\\algorithms\\coursera\\integer_array.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = "";
        int idx = 0;
        while((line = bufferedReader.readLine()) != null){
            arrayList.add(Integer.parseInt(line));
        }
        bufferedReader.close();

        long inv_count = 0;

        for (int i = 0; i < arrayList.size() - 1; i++){
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i) > arrayList.get(j)) {
                    inv_count++;
                }
            }
        }
        System.out.println(inv_count);

    }
//2407905288


    private static void mergeSort(ArrayList<Integer> arr, int left, int right){
        int mid;

        if(left < right){
            mid = (left + right) /2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(ArrayList<Integer> arr, int left, int mid, int right) {
        int i, j, k, l;

        i = left;
        j = mid + 1;
        k = left;

        while(i <= mid && j <= right){
            if(arr.get(i) <= arr.get(j)){
                sortedArr[k++] = arr.get(i++);
            }else{
                inversion = inversion.add(new BigInteger(String.valueOf(mid - i + 1)));
                sortedArr[k++] = arr.get(j++);
            }
        }

        if(i > mid){
            for(l = j; l <= right; l++){
                sortedArr[k++] = arr.get(l);
                inversion = inversion.add(BigInteger.ONE);
            }
        }else{
            for(l = i; l <= mid; l++){
                sortedArr[k++] = arr.get(l);
            }
        }

        for(l = left; l <= right; l++){
            arr.set(l, sortedArr[l]);
        }
    }
}
