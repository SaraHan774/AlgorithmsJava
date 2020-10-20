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

        for (int i = 0; i < participant.length; i++) {
            int count = 1;
            String part = participant[i];

            if(partMap.get(part) == null){
                partMap.put(part, count);
            }else{
                count = partMap.get(part);
                partMap.put(part, ++count);
            }
        }

        for (int i = 0; i < completion.length; i++) {
            if(partMap.containsKey(completion[i])){
                int v = partMap.get(completion[i]);
                partMap.put(completion[i], --v);
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
