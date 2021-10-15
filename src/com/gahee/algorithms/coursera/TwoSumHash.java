package com.gahee.algorithms.coursera;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class TwoSumHash {

    private static long [] arr = new long[1000000];
    private static int idx = 0;
    static AtomicInteger tCount = new AtomicInteger(0);

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
                arr[idx++] = Long.parseLong(temp);
            }
            connection.disconnect();
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } // end of reading test set

        // x + y = t 를 만족하는 값을 찾기
        // -10000 <= t <= 10000

        Worker worker1 = new Worker(arr, -10000, -8000);
        Worker worker4 = new Worker(arr, -8000, -5000);
        Worker worker5 = new Worker(arr, -5000, -3000);
        Worker worker2 = new Worker(arr, -3000, -1000);
        Worker worker3 = new Worker(arr, -1000, -500);
        Worker worker6 = new Worker(arr, -500, 0);
        Worker worker7 = new Worker(arr, 0, 1500);
        Worker worker8 = new Worker(arr, 1500, 3000);
        Worker worker9 = new Worker(arr, 3000, 5000);
        Worker worker10 = new Worker(arr, 5000, 8000);
        Worker worker11 = new Worker(arr, 8000, 10001);

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);
        Thread t3 = new Thread(worker3);
        Thread t4 = new Thread(worker4);
        Thread t5 = new Thread(worker5);
        Thread t6 = new Thread(worker6);
        Thread t7 = new Thread(worker7);
        Thread t8 = new Thread(worker8);
        Thread t9 = new Thread(worker9);
        Thread t10 = new Thread(worker10);
        Thread t11 = new Thread(worker11);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
            t11.join();

            System.out.println(tCount.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class Worker implements Runnable {
        long [] arr;
        int start;
        int end;

        public Worker(long [] arr, int start, int end){
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end ; i++) {
                twoSum(arr, i);
            }
        }

        public long[] twoSum(long [] nums, int target) {
            Map<Long, Integer> map = new HashMap<>();
            for (int j = 0; j < nums.length; j++) {
                long comp = target - nums[j];
                if (map.containsKey(comp)) {
                    tCount.getAndIncrement();
                    return new long [] {j, map.get(comp)};
                }
                map.put(nums[j], j);
            }
            return new long[0];
        }
    }

}