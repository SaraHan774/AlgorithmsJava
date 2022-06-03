package com.gahee.algorithms.stepbystep.step2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class P2480 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split("\\s+");
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (String str : strs) {
            int n = Integer.parseInt(str);

            if (n > max) {
                max = n;
            }

            if (map.containsKey(n)) {
                int v = map.get(n) + 1;
                map.put(n, v);
            } else {
                map.put(n, 1);
            }
        }

        if (map.size() == 3) {
            // no equal numbers
            System.out.println(max * 100);
        } else if (map.size() == 2) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 2) {
                    int k = entry.getKey();
                    System.out.println(1000 + k * 100);
                    break;
                }
            }
        } else {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey();
                System.out.println(10000 + k * 1000);
                break;
            }
        }
    }
}
