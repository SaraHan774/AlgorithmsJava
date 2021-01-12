package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lec2_MakeBigNumber {

    public static void main(String[] args) {
        int [] nums = {1};
        System.out.println(solution(nums));
    }


    public static String solutionLambda(int [] numbers){
        String answer = IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining());

        if(answer.startsWith("0")){
            return "0";
        }
        return answer;
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String [] arr = new String[numbers.length];
        int i = 0;
//        boolean isAllZero = true;

        if(numbers.length == 1){
            return String.valueOf(numbers[0]);
        }

        for(int n : numbers){
//            if(n != 0){ isAllZero = false; }
            arr[i++] = String.valueOf(n);
            //arr[i++] = n + "";
        }

//        if(isAllZero){
//            return "0";
//        }

        //자바에서 제공하는 함수를 사용하는게 더 좋은거임
        Arrays.sort(arr, (s1, s2) -> {
            String a = s1 + s2;
            String b = s2 + s1;
            // 두 개를 이렇게 문자열 연결을 했을때 더 큰 숫자가 큰거임 !
            return -Integer.compare(Integer.parseInt(a), Integer.parseInt(b));

//            int idx1 = 0;
//            int idx2 = 0;
//            System.out.println(s1 + " " + s2);
//            while(idx1 < s1.length() && idx2 < s2.length()){
//                int num1 = Character.getNumericValue(s1.charAt(idx1));
//                int num2 = Character.getNumericValue(s2.charAt(idx2));
//                if(num1 > num2){
//                    System.out.println(s1 + " > " + s2);
//                    return -1;
//                }else if(num1 < num2){
//                    System.out.println(s1 + " < " + s2);
//                    return 1;
//                }else{
//                    idx1++;
//                    idx2++;
//                }
//            } // 길이가 둘중 하나라도 도달하면 끝난다.

            //30 3 - 앞 자리가 같고 30이 두자리지만, 3이 먼저 와야 함.
//            if(Integer.parseInt(s1) % 10 == 0){
//                return 1;
//            }else if(Integer.parseInt(s2) % 10 == 0){
//                return -1;
//            }else{
//                return -Integer.compare(s1.length(), s2.length());
//            }
        });

        System.out.println(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        for (String s : arr){
            sb.append(s);
        }
        answer = sb.toString();

        // 000 과 같이 0 으로 시작하는 경우 그냥 0 을 리턴한다.
//        if(answer.charAt(0) == '0'){
//            return "0";
//        }
        //위와 같이 charAt 을 하는 것 보다 startsWith("0")
        //가 더 낫다 !
        if(answer.startsWith("0")){
            return "0";
        }

        return answer;
    }
}
