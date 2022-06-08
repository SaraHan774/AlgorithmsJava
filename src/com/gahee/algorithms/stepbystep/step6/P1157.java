package com.gahee.algorithms.stepbystep.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1157 {
    public static void main(String[] args) {
        // 단어 하나에서 가장 많이 사용된 알파벳의 개수를 출력, 동일 개수 두개이상 나오면 물음표 출력
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String word = line.toUpperCase();
        char[] chars = word.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                map.put(aChar, 1);
            } else {
                int count = map.get(aChar) + 1;
                map.put(aChar, count);
            }
        }

        int max = Integer.MIN_VALUE;
        char maxChar = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            char key = entry.getKey();

            if (value > max) {
                max = value;
                maxChar = key;
            } else if (max == value) {
                System.out.println('?');
                return;
            }
        }
        System.out.println(maxChar);
    }
}

class Solution {

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

// TODO : 두 개 코드가 어떻게 다른건지 알아보기 !

