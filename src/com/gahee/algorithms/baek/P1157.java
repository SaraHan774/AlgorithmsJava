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



    private void otherAnswer(String input){
        input = input.toUpperCase();
        int arr [] = new int[26];
        int max=0;
        char result = '?';
        for(int i=0; i<input.length(); i++){
            // 문자의 위치에 맞게 배열의 인덱스를 1 증가
            arr[input.charAt(i) - 65]++;
            // 해당 인덱스의 요소가 max 인지 판별
            if(max < arr[input.charAt(i)-65]){
                max = arr[input.charAt(i)-65];
                result = input.charAt(i);
            }
             //만약 max 와 값이 같다면 result 를 '?' 로 지정한다.
            else if(max == arr[input.charAt(i)-65]){
                result ='?';
            }
        }
        System.out.print(result);
    }
}
