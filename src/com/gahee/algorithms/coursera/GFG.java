package com.gahee.algorithms.coursera;
// Java implementation of the approach 
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
  
public class GFG { 
  
    // Function to count the number of inversions 
    // during the merge process 
    private static long mergeAndCount(int[] arr,
                                int l, int m, int r)
    { 
  
        // Left subarray 
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
  
        // Right subarray 
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
  
        int i = 0, j = 0, k = l, swaps = 0;
  
        while (i < left.length && j < right.length)  
        { 
            if (left[i] <= right[j]) 
                arr[k++] = left[i++]; 
            else { 
                arr[k++] = right[j++]; 
                swaps += (m + 1) - (l + i); 
            } 
        } 
        return swaps; 
    } 
  
    // Merge sort function 
    private static long mergeSortAndCount(int[] arr,
                                        int l, int r)
    { 
  
        // Keeps track of the inversion count at a 
        // particular node of the recursion tree 
        long count = 0;
  
        if (l < r) { 
            int m = (l + r) / 2;
  
            // Total inversion count = left subarray count 
            // + right subarray count + merge count 
  
            // Left subarray count 
            count += mergeSortAndCount(arr, l, m);
  
            // Right subarray count 
            count += mergeSortAndCount(arr, m + 1, r);
  
            // Merge count 
            count += mergeAndCount(arr, l, m, r);
        } 
  
        return count; 
    } 
  
    // Driver code 
    public static void main(String[] args) throws IOException {

        ArrayList<Integer> arrayList = new ArrayList<>();

        File file =
                new File("C:\\Users\\sarah\\Desktop\\2020\\Algorithms\\src\\com\\gahee\\algorithms\\coursera\\integer_array.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = "";
        long idx = 0;
        while((line = bufferedReader.readLine()) != null){
            arrayList.add(Integer.parseInt(line));
        }
        bufferedReader.close();

        int [] arr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i]=arrayList.get(i);
        }

        System.out.print(mergeSortAndCount(arr, 0,
                                        arr.length - 1));

        System.out.println(Arrays.toString(arr));
    }
} 
  
// This code is contributed by Pradip Basak 
