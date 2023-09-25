package com.gahee.algorithms.programmers;


import java.util.ArrayList;

public class Hamburger {

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int anw = new Solution().solution(arr);
        System.out.println(anw);
    }

    private static class Solution {
        int answer = 0;
        int WINDOW = 4;

        public int solution(int[] ingredient) {
            ArrayList<Integer> arrayList = new ArrayList<>(ingredient.length);
            for (int i : ingredient) {
                arrayList.add(i);
            }
            getAnswer(arrayList);
            return answer;
        }

        private void getAnswer(ArrayList<Integer> ingredient) {
            int k = 0;
            for (int i = 0; i < ingredient.size() - WINDOW + 1; i++) {
                if (
                        ingredient.get(i) == 1 &&
                                ingredient.get(i + 1) == 2 &&
                                ingredient.get(i + 2) == 3 &&
                                ingredient.get(i + 3) == 1
                ) {
                    ingredient.subList(i, i + WINDOW).clear();
                    answer++;
                    k++;
                    break;
                }
            }

            if (k > 0) {
                System.out.println(ingredient);
                getAnswer(ingredient);
            }
        }
/*
        private void getAnswer2(ArrayList<Integer> ingredient) {
            int k = 0;
            int i = 0;

            while (i < ingredient.size() - WINDOW + 1) {
                if (ingredient.get(i) == 1 &&
                        ingredient.get(i + 1) == 2 &&
                        ingredient.get(i + 2) == 3 &&
                        ingredient.get(i + 3) == 1
                ) {
                    // Instead of clearing sublists, update the index
                    i += WINDOW;
                    answer++;
                    k++;
                } else {
                    // Move to the next element
                    i++;
                }
            }

            if (k > 0) {
                getAnswer(ingredient);
            }
        }*/
    }
}
