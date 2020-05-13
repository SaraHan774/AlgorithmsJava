package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1152 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();

        otherAnswer(input);
        anotherAnswer();

        String [] splitInput = input.split(" ");
//        ArrayList<String> arrayList = new ArrayList<>();
        int answer = 0;
        for (String s : splitInput) {
            if (!s.isEmpty()) {
//                arrayList.add(s);
                answer++;
            }
        }
//        System.out.println(arrayList.size());
        System.out.println(answer);
        br.close();
    }

    private static void otherAnswer(String input){
        StringTokenizer st = new StringTokenizer(input);
        int a = 0;
        while(st.hasMoreTokens()){
            st.nextToken();
            a++;
        }
        System.out.println(a);
    }

    // 공백이 중간에 여러개 들어있으면 제거가 안되는데 이 문제에서는 정답이라고 ...
    private static void anotherAnswer(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        String [] inputArray = input.split(" ");
        if("".equals(input)){
            System.out.println(0);
        }else{
            System.out.println(inputArray.length);
        }
    }
}
