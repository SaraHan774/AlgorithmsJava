package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P1316 {

    public static void main(String[] args) throws IOException {
        //그룹 단어의 개수를 출력하라.
        //중복되는 문자들은 붙어있어야 한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 0){
            System.out.println(0);
            br.close();
            System.exit(0);
        }

        String [] inputs = new String[N];
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }

        otherAnswer(N, inputs);

        int answer = N;
        for (int i = 0; i < N; i++) {
//모든 단어들에 대해서 새로운 맵이 필요하다
            Map<Character, Integer> map =  new HashMap<>();

            for (int j = 0; j < inputs[i].length(); j++) {
                //그룹 단어인지 확인한다.
                //중복을 확인한다.
                char c = inputs[i].charAt(j);
                if(!map.containsKey(c)){
                    map.put(c, j);
                }else {
                    //연달아 있는 문자라면
                    if(j - map.get(c) == 1) {
                        // 중복된 문자의 인덱스 값을 업데이트 한다
                        map.put(c, j);
                    }else{
                        answer--;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static void otherAnswer(int N, String [] inputs){
        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean isGroupWord = true;
            StringBuilder sb;
            sb = new StringBuilder();
            String word = inputs[i];

            for (int j = 0; j < word.length(); j++) {
                System.out.println(word);
                String check = String.valueOf(word.charAt(j));

                if(sb.toString().contains(check)){
                    // 문자가 들어있다면 마지막 인덱스를 확인한다.
                    // 확인했을때 전체 sb 의 길이의 -1 과 같지 않다면
                    // 즉, 연이어서 나타나는 문자가 아니라면 false 로 지정
                    if(sb.toString().lastIndexOf(check) != sb.length()-1){
                        isGroupWord = false;
                        break;
                    }
                }else{
                    sb.append(check);
                }
            }// end of inner for loop
            if(isGroupWord){
                answer++;
            }
        }// end of outer for loop
        System.out.println(answer);
    }
}
