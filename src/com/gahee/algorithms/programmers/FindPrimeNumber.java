package com.gahee.algorithms.programmers;

import java.util.HashSet;

public class FindPrimeNumber {
    public static void main(String[] args) {
        String n = "17";
        String n1 = "011";
        String n2 = "040503021";


//        System.out.println(solution(n));
        System.out.println(solution(n1));
//        System.out.println(solution(n2));
    }

    public static int solution(String number){
        int answer = 0;
        //각 종이 조각에 적힌 숫자가 적힌 문자열

        //각 숫자에 대해서 한개씩 소수인지 만들어 보아야 함.
        int [] arr = new int[number.length()];
        for (int i = 0; i < number.toCharArray().length; i++) {
            arr[i] = Character.getNumericValue(number.toCharArray()[i]);
        }

        HashSet<Integer> set = new HashSet<>();

        //0, 1, 1이 담겨져 있는 배열이 있다고 할 때
        combinations(arr, "");

        answer = set.size();

        return answer;
    }

    public static void combinations(int [] arr, String result){
        StringBuilder sb = new StringBuilder(result);
        if(result.length() == arr.length){
            System.out.println(sb);
            return;
        }else{

        }
    }

    private static int primeHelper(int [] arr, int s, HashSet<Integer> set){
        int start = arr[s];
        StringBuilder sb = new StringBuilder();

        //시작점 소수인지 판별
        //isPrimeNum(start) 이면 set 에다가 추가하기

        for (int i = 0; i < arr.length; i++) {
            boolean isPrime = false;
            if(i == s){ //기준점과 인덱스가 같으면 스킵
                continue;
            }else{
                sb.append(start);
                int number = Integer.parseInt(sb.toString());
                //sb 가 소수인지 판별한 후 set 에다가 추가하기
                if(isPrimeNum(number)){
                    set.add(number);
                }
            }
        }

        return 0;
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
        }
        if(idx == num){
            result = true;
        }
        return result;
    }
}
