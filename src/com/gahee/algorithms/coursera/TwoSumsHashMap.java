package com.gahee.algorithms.coursera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumsHashMap {

    static long [] arr = new long[1000000];
    static int i = 0;
    static int i2 = 0;
    static int count = 0;
    static Map<Long, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        try {
            String testSetLink = "https://d3c33hcgiwev3.cloudfront.net" +
                    "/_6ec67df2804ff4b58ab21c12edcb21f8_algo1-programming_prob-2sum.txt?" +
                    "Expires=1634428800&" +
                    "Signature=kVnHi44hoYnltNQ5imGlXFNYANmLwSc6eq62UYsQK-Wx1HOvEOVkGSzenJv9vS2JbPNtYwDzeORP6Y0cxIcrCRyHuxyL-PlNBIi7DBuljhmshH5YLz8CSB7UrtH2qhzGsM7u0x5yYsD8WDg5d2ZgkNRr2hhHFeMj6eIRdN0qfp8_&" +
                    "Key-Pair-Id=APKAJLTNE6QMUY6HBC5A";

            URL url = new URL(testSetLink);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                map.put(Long.parseLong(temp), i++);
                arr[i2++] = Long.parseLong(temp);
            }

            connection.disconnect();
            bufferedReader.close();
            System.out.println("end of reading file...");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } // end of reading test set

        System.out.println("start ... ");

        for (int t = -10000; t <= 10000; t++) {
            System.out.print(t + ", ");
            twoSum(arr, t);
        }
        System.out.println(count);
    }

    public static long[] twoSum(long [] nums, int target) {
        for (int j = 0; j < nums.length; j++) {
            long comp = target - nums[j];
            if (map.containsKey(comp)) {
                count++;
                return new long [] {j, map.get(comp)};
            }
        }
        return new long[0];
    }
}

