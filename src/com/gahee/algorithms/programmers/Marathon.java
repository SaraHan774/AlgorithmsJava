package com.gahee.algorithms.programmers;

import java.util.*;

public class Marathon {


    public static void main(String[] args) {
        //["leo", "kiki", "eden"], ["eden", "kiki"]

  	//["mislav", "stanko", "mislav", "ana"], ["stanko", "ana", "mislav"]
        String [] part = {"mislav", "stanko", "mislav", "ana"};
        String [] comp = {"stanko", "ana", "mislav"};

        String result = solution(part, comp);
        System.out.println("result = "  + result);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> partMap = new HashMap<>();

        for (String s : participant) {
            int count = 1;

            if (partMap.get(s) == null) {
                partMap.put(s, count);
            } else {
                count = partMap.get(s);
                partMap.put(s, ++count);
            }
        }

        for (String s : completion) {
            if (partMap.containsKey(s)) {
                int v = partMap.get(s);
                partMap.put(s, --v);
            }
        }

        for (Map.Entry<String, Integer> e : partMap.entrySet()) {
            if(e.getValue() > 0){
                answer = e.getKey();
                return answer;
            }
        }
        return answer;
    }
}
