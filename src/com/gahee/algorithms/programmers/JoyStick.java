package com.gahee.algorithms.programmers;

import java.util.Arrays;

public class JoyStick {

    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
    }

    public static int solution(String name) {
        int answer = 0;

        char [] nameAscii = name.toCharArray();
        int [][] alpha1 = new int[13][2];
        int [][] alpha2 = new int[13][2];

        for (int i = 0; i < 13; i++) {
            alpha1[i][0] = i + 65;
            alpha2[i][0] = 90 - i;
            alpha1[i][1] = i;
            alpha2[i][1] = i + 1;
        }
        System.out.println(Arrays.deepToString(alpha1));
        System.out.println(Arrays.deepToString(alpha2));

        for (int i = 0; i < nameAscii.length; i++) {
            int cur = nameAscii[i];
            System.out.println("current alphabet " + (char)(cur));
            if(cur == (int)'A'){
                answer++;
            }else if(cur < (int)'M'){
                System.out.println("moving " + alpha1[cur - 65][1]);
                answer += alpha1[cur - 65][1];
            }else{
                System.out.println("moving " + alpha2[90 - cur][1]);
                answer += alpha2[90 - cur][1];
            }
        }

        return answer;
    }
}
