package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class P1157 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String upperInput = input.toUpperCase();

        char [] inputArray = upperInput.toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for (char c : inputArray) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int count = map.get(c);
                map.put(c, ++count);
            }
        }

        Iterator<Character> it = map.keySet().iterator();

        int max = 0;
        char charMax = ' ';

        while(it.hasNext()){
            char key = it.next();
            int val = map.get(key);
            if(val > max){
                max = val; //max set to val
                charMax = key;
            }else if(val == max){
                charMax = '?';
            }
        }

        System.out.println(charMax);

        br.close();
    }
}
