package com.gahee.algorithms.coursera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Quick {

    static final String FILE_PATH = "C:\\Users\\sarah\\Desktop\\2020\\Algorithms\\src\\com\\gahee\\algorithms\\coursera\\quick.txt";
    static int comparisons = 0;

    public static void main(String[] args) throws IOException {
        int [] arr = new int[10000];

        File file = new File(FILE_PATH);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        int idx = 0;

        while ((line = bufferedReader.readLine()) != null) {
            arr[idx] = Integer.parseInt(line);
            ++idx;
        }
        bufferedReader.close();


        quickSort(arr, 0, arr.length - 1);

        System.out.println("Comparisons Total = " + comparisons);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int [] arr, int left, int right){
//        System.out.println("left = " + left + ", " + "right = " + right);
        if(left < right) {
            int p = partitionPivotEnd(arr, left, right);
            quickSort(arr, left, p - 1);
            quickSort(arr, p + 1, right);
        }
    }

    //162085
    public static int partition(int [] arr, int left, int right){
        int i = left + 1;
        int pivot = arr[left];
//        System.out.println("\n\npivot = " + pivot);

        //j 는 계속 증가함
        for (int j = left + 1; j < right + 1; j++) {
            comparisons++;
            if(arr[j] < pivot){
                //swap a[j] and a[i]
//                System.out.println("swap " + arr[j] + " <=> " + arr[i]);
                int a = arr[j];
                arr[j] = arr[i];
                arr[i] = a;
                i++;
                //swap 이 이루어지면 i 도 증가시킴
            }
        }
        //arr[left] <-> arr[i - 1]
//        System.out.println("swap pivot " + arr[left] + " <==> " + arr[i - 1]);
        int a = arr[left];
        arr[left] = arr[i-1];
        arr[i-1] = a;
//        System.out.println(Arrays.toString(arr) + "\n\n");
        return (i - 1);
    }

    //배열의 마지막 요소를 pivot 으로 하는 경우의 파티션 함수 ... ?
    //거꾸로 정렬되어서 나옴 ...
    public static int partitionReverse(int [] arr, int left, int right) {
        int i = right - 2;
        int pivot = arr[right - 1];

        for (int j = right - 2; j >= left; j--) {
            comparisons++;
            if (arr[j] < pivot) {
                int a = arr[j];
                arr[j] = arr[i];
                arr[i] = a;
                i--;
            }
        }

        int a = arr[right - 1];
        arr[right - 1] = arr[i + 1];
        arr[i + 1] = a;
        return (i + 1);
    }

    //160361 -- 오답이라고 ..
    public static int partitionPivotEnd(int [] arr, int left, int right){
        int i = left;
        int pivot = arr[right];

        for (int j = left; j < right; j++){
            comparisons++;

            if(arr[j] < pivot){
                int k = arr[j];
                arr[j] = arr[i];
                arr[i] = k;
                i++;
            }
            //pivot 보다 큰 숫자가 나오면 j만 증가시킴
        }

        int k = arr[i];
        arr[i] = arr[right];
        arr[right] = k;
        return i;
    }

    public static int partitionPivotMedian(int [] arr, int left, int right){
        int i = left;
        //int med = arr.length/2 - 1;
        //int pivot = arr[med];
//        System.out.println("\n\npivot = " + pivot);

        // Selecting the  pivot
        int first = left;
        int second = (right - left)/2;
        int third = right;
        // median.txt for first three
        int pivot = Math.max(Math.min(arr[first],arr[second]),
                Math.min(Math.max(arr[first],arr[second]),arr[third]));


        //j 는 계속 증가함
        for (int j = left; j < right; j++) {
            comparisons++;
            if(arr[j] < pivot){
                //swap a[j] and a[i]
//                System.out.println("swap " + arr[j] + " <=> " + arr[i]);
                int a = arr[j];
                arr[j] = arr[i];
                arr[i] = a;
                i++;
                //swap 이 이루어지면 i 도 증가시킴
            }
        }
        //arr[left] <-> arr[i - 1]
//        System.out.println("swap pivot " + arr[left] + " <==> " + arr[i - 1]);
        int a = arr[left];
        arr[left] = arr[i];
        arr[i] = a;
//        System.out.println(Arrays.toString(arr) + "\n\n");
        return (i);
    }


}