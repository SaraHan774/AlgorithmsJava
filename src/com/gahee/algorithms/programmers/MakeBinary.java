package com.gahee.algorithms.programmers;

public class MakeBinary {

    public static void main(String[] args) {
        int num = 17;
        StringBuilder stringBuilder = new StringBuilder();
        while(num/2 > 0){
            stringBuilder.append(num%2);
            num = num/2;
        }
        System.out.println("num => " + num);
        // 4 / 2 => 2 / 2 => 1 / 2 => 1, 0, 0 순서대로 와야 함.
        // 5 / 2 => 2 / 2 => 1 / 2 => 1, 0, 0, 1 이 되어야 함.
        // 이렇게 되므로 ... 마지막에는 항상 1이 나오는 것을 append 해주어야 함.
        stringBuilder.append("1");

        System.out.println(stringBuilder.reverse());
    }
}
