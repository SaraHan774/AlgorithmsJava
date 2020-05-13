package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5622 {

    public static void main(String[] args) throws IOException {

        // 각 숫자에 대응하는 알파벳들이 있다.
        // 1과 0에는 알파벳이 없고 1을 누르려면 2초가 필요하다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char [] inputArray = br.readLine().toCharArray();

        // 어떤 문자에 어떤 숫자가 대응하는지 표현한다.
        // 65 + 26 - 1 = 90
        int [][] dial = new int[10][3];
        int time = 2;

        dial[0][0] = 0;
        dial[0][1] = 11;
        dial[0][2] = 0;

        for (int i = 1; i < 10; i++) {
            dial[i][0] = i;
            dial[i][1] = time++;

            if(i == 1){
                dial[i][2] = 0; //문자 없음
            } else if(i == 9){
                dial[i][2] = 90;
            }else if(i == 7){
                dial[i][2] = 83;
            }else{
                if(i == 2){
                    dial[i][2] = 67;
                }else{
                    dial[i][2] = dial[i-1][2] + 3;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < inputArray.length; i++) {
            //어떤 문자인지 확인하고
            int d = inputArray[i];

            for (int j = 0; j < 10; j++) {
                if(d <= dial[j][2]){
                    //문자에 대응하는 숫자를 확인하고
                    answer += dial[j][1];
                    //해당 문자를 거는데 필요한 시간을 더해나간다.
                    break;
                }
            }
        }
        System.out.println(answer);

        br.close();

    }
}
