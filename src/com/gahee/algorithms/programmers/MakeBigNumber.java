package com.gahee.algorithms.programmers;

import java.util.PriorityQueue;

public class MakeBigNumber {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));

    }

    public static String solution(String number, int k) {
        String answer = "";
        char [] original = number.toCharArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));

        boolean [] visited = new boolean[number.length()];
        comb(original, visited, 0, original.length, original.length - k, pq);
        answer = pq.peek() + "";
        return answer;
    }

    static void comb(char[] arr, boolean[] visited, int depth, int n, int r, PriorityQueue<Integer> result) {
        if (r == 0) {
            print(arr, visited, n, result);
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1, result);

        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r, result);
    }

    // 배열 출력
    static void print(char[] arr, boolean[] visited, int n, PriorityQueue<Integer> result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sb.append(arr[i]);
            }
        }
        result.add(Integer.parseInt(sb.toString()));
    }
}
