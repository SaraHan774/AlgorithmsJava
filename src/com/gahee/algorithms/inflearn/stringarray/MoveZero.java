package com.gahee.algorithms.inflearn.stringarray;

public class MoveZero {

    public static void main(String[] args) {
        // 배열, 배열의 인덱스를 조작한다.
        int [] numbers = {0, 3, 2, 0, 8 ,5};
        int index = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] != 0) {
                // 0 이 아닌 것을 배열의 처음부터 다시 집어넣는다.
                // 새로운 배열을 만들지 않아도 된다.
                numbers[index] = numbers[i];
                index++;
            }
        }

        while(index < numbers.length){
            // 0 이 아닌 숫자가 들어간 마지막 인덱스의 다음부터
            // 순서대로 0을 집어넣는다.
            numbers[index++] = 0;
        }

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

}
