package com.gahee.algorithms.baek;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P10809 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";

        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char [] inputArray = input.toCharArray(); //input 을 초기화해야 한다.
        // 모든 소문자 알파벳들이 담긴 배열을 만든다
        char [] alphabets = new char[26];
        for (int i = 0; i < alphabets.length; i++) {
            alphabets[i] = (char)(i + 97);
        }

        // 인풋에 들어있는지 확인한다
        // 처음으로 등장한 위치를 기억해야 한다 - Map 을 사용하자.
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < alphabets.length; i++) {
            boolean contains = false;

            for (int j = 0; j < inputArray.length; j++){
                // 알파벳이 들어있는지 확인
                if (alphabets[i] == inputArray[j]
                        && !map.containsKey(inputArray[j])) {
                    // map 에 이미 있지 않은 경우에만 추가한다
                    map.put(inputArray[j], j);
                    contains = true; //들어있다는 플래그를 true 로 설정
                }
            }
            //들어있었다면 인덱스 출력, 없으면 -1 출력
            if(contains){
                System.out.print(map.get(alphabets[i]) + " ");
            }else{
                System.out.print("-1 ");
            }
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
