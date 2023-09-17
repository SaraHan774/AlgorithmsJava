package com.gahee.algorithms.programmers;

import java.util.HashMap;

public class CharacterType {
//https://school.programmers.co.kr/learn/courses/30/lessons/118666
    public static void main(String[] args) {
        String[] test = {"TR", "RT", "TR"};
        int[] choice = {7, 1, 3};

        Solution s = new Solution();
        System.out.println(s.solution(test, choice));
    }

    static class Solution {
        private final int[][] k = {
                {1, 3},
                {2, 2},
                {3, 1},
                {4, 0},
                {5, 1},
                {6, 2},
                {7, 3}
        };

        public String solution(String[] survey, int[] choices) {
            String answer;
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('R', 0);
            map.put('T', 0);
            map.put('C', 0);
            map.put('F', 0);
            map.put('J', 0);
            map.put('M', 0);
            map.put('A', 0);
            map.put('N', 0);

            String[] strings = {"R", "C", "J", "A"};

            for (int i = 0; i < survey.length; i++) {
                String s = survey[i];
                int choice = choices[i];

                if (choice > 4) {
                    char c = s.charAt(1);
                    int p = map.get(c);
                    map.put(c, p + k[choice - 1][1]);
                } else if (choices[i] < 4) {
                    char c = s.charAt(0);
                    int p = map.get(c);
                    map.put(c, p + k[choice - 1][1]);
                }
                // else { do nothing }

                if (s.contains(strings[0])) {
                    // R or T
                    int p = map.get('R');
                    int q = map.get('T');
                    if (p >= q) {
                        strings[0] = "R";
                    } else {
                        strings[0] = "T";
                    }
                } else if (s.contains(strings[1])) {
                    // C or F
                    int p = map.get('C');
                    int q = map.get('F');
                    if (p >= q) {
                        strings[1] = "C";
                    } else {
                        strings[1] = "F";
                    }
                } else if (s.contains(strings[2])) {
                    // J or M
                    int p = map.get('J');
                    int q = map.get('M');
                    if (p >= q) {
                        strings[2] = "J";
                    } else {
                        strings[2] = "M";
                    }
                } else {
                    // A or N
                    int p = map.get('A');
                    int q = map.get('N');
                    if (p >= q) {
                        strings[3] = "A";
                    } else {
                        strings[3] = "N";
                    }
                }
            }

            answer = String.join("", strings);
            return answer;
        }
    }
}
