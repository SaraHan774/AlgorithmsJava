package com.gahee.algorithms.programmers;

public class MakeBigNumber1 {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int total = number.length();
        //number 는 100만 자리 이하의 숫자
        int [] numArr = new int[total];

        if(number.length() == 1){
            return number;
        }

        char [] charArr = number.toCharArray();
        for (int i = 0; i < total; i++) {
            numArr[i] = Character.getNumericValue(charArr[i]);
        }

        //몇자리 숫자를 만들어야 하는지
        int digits = total - k;

        //2번째 자릿수를 찾아라
        int maxIdx = -1;
        for (int i = digits; i > 0; i--) {
            int max = -1;
            //0, 1, 2 중에서 최대값을 찾아 두번째 자리에 넣고
            //2, 3 중에서 최대값을 찾아 다시 ...
            for (int j = maxIdx + 1; j <= total - i; j++) {
                if(max < numArr[j]){
                    max = numArr[j];
                    maxIdx = j;
                    if(max == 9){
                        break;
                    }
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }
}
