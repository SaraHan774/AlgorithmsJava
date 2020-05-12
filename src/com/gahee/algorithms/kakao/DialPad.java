package com.gahee.algorithms.kakao;

public class DialPad {

    int [][] dial = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {-1, 0, -2}
    };

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftNum = -1, rightNum = -2;

        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                answer.append("L");
                leftNum = n;
            } else if (n == 3 || n == 6 || n == 9) {
                answer.append("R");
                rightNum = n;
            } else {
                if (getDistance(n, rightNum) < getDistance(n, leftNum)) {
                    answer.append("R");
                    rightNum = n;
                } else if (getDistance(n, rightNum) > getDistance(n, leftNum)) {
                    answer.append("L");
                    leftNum = n;
                } else {
                    if (hand.equals("left")) {
                        answer.append("L");
                        leftNum = n;
                    } else {
                        answer.append("R");
                        rightNum = n;
                    }
                }
            }
        }

        return answer.toString();
    }

    public int getDistance(int x, int y){
        int xi = -10, xj = -10, yi = -10, yj = -10;
        while(xi == -10 || yi == -10){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 3; j++){
                    if(x == dial[i][j]){
                        xi = i;
                        xj = j;

                    }
                    if(y == dial[i][j]){
                        yi = i;
                        yj = j;

                    }
                }
            }
        }

        double r = Math.sqrt((xi - yi) * (xi - yi) + (xj - yj) * (xj - yj));
        r = Math.ceil(r);

        return (int)r;
    }

}
