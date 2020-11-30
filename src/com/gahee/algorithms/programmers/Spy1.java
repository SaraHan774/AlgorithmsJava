package com.gahee.algorithms.programmers;

import java.util.HashMap;
import java.util.Iterator;

public class Spy1 {

    public static void main(String[] args) {

    }

    public static int solution(String [][] clothes){
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }

        for (Integer integer : map.values()) {
            answer *= integer + 1;
        }
        return answer - 1;
    }
}
