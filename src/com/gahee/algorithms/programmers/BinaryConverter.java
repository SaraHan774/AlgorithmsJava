package com.gahee.algorithms.programmers;

import java.util.Arrays;

public class BinaryConverter {

    public static void main(String[] args) {
        String [] tests = {
                "110010101001",
                "01110",
                "1111111"
        };

        for (String test : tests) {
            System.out.println(Arrays.toString(solution(test)));
        }
    }
    //0 제거 - 스트링 길이 N - N 의 이진표현법
    //s 가 1이 될 때 까지 계속해서 이진 변환을 가하기
    //변환 과정에서 제거된 모든 0의 개수를 배열에 담아 return 하기
    //s 의 길이는 1 이상 150,000이하
    //s 에는 최소한 하나 이상의 1이 있음.

    public static int[] solution(String s) {
        int[] answer;

        int numZero = 0;
        int numConvert = 0;

        while(!s.equals("1")){
            numConvert++;
            char [] arr = s.toCharArray();
            StringBuilder newString = new StringBuilder();

            for (char c : arr) {
                if (c == '0') {
                    //0의 개수를 세기
                    numZero += 1;
                }else{
                    newString.append("1");
                }
            }
//            System.out.println("new = " + newString);
            //newString 의 길이를 이진수로 바꾸기
            int sub = newString.length();
            StringBuilder binary = new StringBuilder();

            while(sub/2 > 0){
                binary.append(sub%2);
                //while 문의 조건이 바뀌는지 꼭 확인할 것
                sub = sub/2;
            }
            binary.append("1");
            s = binary.reverse().toString();
//            System.out.println("s = " + s);
        }

        answer = new int[2];
        answer[0] = numConvert;
        answer[1] = numZero;

        return answer;
    }
}
