package com.gahee.algorithms.programmers;

import java.util.Arrays;

public class Carpet {

    public static void main(String[] args) {
        int [] ans = solution(24, 24);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int y;
        //x + y = brown/2 + 2 >= 6
        //(x - 2)(y - 2) = yellow
        //brown >= 8, yellow >= 1

        for (y = 3; y < 1500; y++) {
            int x = brown/2 + 2 - y;
            if((x - 2) * (y - 2) == yellow){
                answer[0] = x;
                answer[1] = y;
                break;
            }
        }

        return answer;
    }
}
