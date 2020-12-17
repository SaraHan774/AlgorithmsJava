package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.TreeSet;

public class FindPrimeNumber1 {

    static int[] num;
    static TreeSet<Integer> set;
    static boolean[] visited;
    static int answer = 0;
    static String numbers="017";

    public static void main(String[] args) {

        System.out.println(solution(numbers) );
    }

    public static int solution(String numbers) {


        num = new int[numbers.length()];
        set = new TreeSet();


        visited = new boolean[num.length];

        for (int i = 0; i < num.length; i++) { // num배열에 숫자 하나씩 뜯어서 저장
            num[i] = numbers.charAt(i) - '0';
        }

        Arrays.sort(num);// 오름차순 정렬

        for (int i = 0; i < numbers.length(); i++) { // 숫자 조합 구하기
            int[] list = new int[i + 1];
            // *** 리스트의 역할은 무엇인가? *** => 길이 i + 1 짜리 숫자로 만들어 낼 수 있는 수들을 담기 위한 리스트.
            // *** depth = 0 부터 시작해서 길이가 1인 것 부터 조합을 찾아나간다. ***
            System.out.println(Arrays.toString(list));
            combination(0, i + 1, -1, list);
        }

        boolean[] prime = new boolean[set.last() + 1];
        prime[0] = prime[1] = true;
        // 소수 체크
        for (int i = 2; i <= Math.sqrt(set.last()); i++) {
            if (prime[i])
                continue;
            for (int j = i + i; j <= set.last(); j += i) {
                prime[j] = true;
            }
        }
        for(Integer i : set) {
            if(!prime[i])
                answer++;
        }

        return answer;
    }

    static void combination(int depth, int length, int com, int[] list) {
        System.out.println("combination " + " depth = " + depth + " length = " + length + " com = " + com + " list = " + Arrays.toString(list));
        //만약 depth 와 길이가 같아진다면 중간 결과들을 이어붙여서 셋에 저장한다.
        if (depth == length) { // 종료 지점
            System.out.println("finishing depth " + depth + " com " + com);
            String tmp = "";
            for (int i = 0; i < list.length; i++) {// list에 들어있는 숫자 붙여서 set에 저장
                //tmp 스트링에다가 해당 depth 의 숫자 요소들의 조합을 이어붙여서
                //길이 length 짜리 숫자 스트링을 만든 후
                tmp += list[i];
            }
            // 셋에다가 저장한다. parseInt 를 하면 자동으로 문자열 앞의 0 이 없어지는 효과가 있다.
            set.add(Integer.parseInt(tmp));
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            // *** 모든 요소들을 방문하였는지 확인 ***
            if (!visited[i]) {
                visited[i] = true;
                // *** 해당 depth 를 인덱스로 삼아서 숫자를 저장 ***
                list[depth] = num[i];// list에 저장
                // *** depth 를 증가시키고 재귀 호출 ***
                combination(depth + 1, length, i, list);
                visited[i] = false;
            }

        }
    }
}
