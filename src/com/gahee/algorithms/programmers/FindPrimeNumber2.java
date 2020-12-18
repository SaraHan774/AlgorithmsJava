package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.HashSet;

public class FindPrimeNumber2 {

    static boolean [] visited;
    static HashSet<Integer> set;

    public static void main(String[] args) {
        String s = "17";

        solution(s);
    }

    private static int solution(String numbers){
        int answer = 0;
        visited = new boolean[numbers.length()];
        set = new HashSet<>();
        int [] numArr = new int[numbers.length()];

        //문자의 배열을 숫자의 배열로 전환하기
        char [] numCharArr = numbers.toCharArray();
        for (int i = 0; i < numCharArr.length; i++) {
            numArr[i] = Character.getNumericValue(numCharArr[i]);
        }

        Arrays.sort(numArr);

        //숫자 배열을 순회하면서 조합 찾기
        //i 가 나타내는 것은 자릿수
        for (int i = 0; i < numArr.length; i++) {
            int [] subArr = new int[i + 1]; //1자리수, 2자리수, 3자리수 차례대로 만들어 나가기
            combination(numArr, subArr, 0, i+1);
        }

//        System.out.println(set);
        answer = set.size();
        return answer;
    }

    private static void combination(int [] arr, int [] subArr, int depth, int length){
        System.out.println(
                "Depth = " + depth + "\n"
                + "Length = " + length + "\n"
                + "Arr = " + Arrays.toString(arr) + "\n"
                + "Sub Arr = " + Arrays.toString(subArr) + "\n"
        );

        StringBuilder sb = new StringBuilder();

        if(length == depth){
            System.out.println("\nfinishing ... \n");
            for (int j : subArr) {
                sb.append(j);
                int num = Integer.parseInt(sb.toString());
                if(isPrimeNum(num)){
                    set.add(num);
                }
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if(!visited[i]){
                visited[i] = true;
                //숫자를 서브 배열에 집어넣은 후 재귀호출 !
                subArr[depth] = arr[i];
                System.out.println("\nrecursive call ... " + i + "\n");
                combination(arr, subArr, depth + 1, length);
                visited[i] = false;
            }
        }
    }

    private static boolean isPrimeNum(int num){
        boolean result = false;

        if(num == 0 || num == 1){
            return false;
        }
        int idx = 2;

        while(idx < num){
            if(num%idx != 0){
                idx++;
            }else{
                break;
            }
//            System.out.println(num + " / " + idx);
        }

        if(idx == num){
            result = true;
        }
        return result;
    }
}
