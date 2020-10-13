package com.gahee.algorithms.leetcode;

public class AlienLanguage {

    public static void main(String[] args) {
        String [] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        //h > l > a > b > ....
        //index
        boolean result = isAlienSorted(words, order);
        System.out.println(result);
    }

    public static boolean isAlienSorted(String [] words, String order){
        if(words.length == 1){
            return true;
        }
        char [] orderArr = order.toCharArray();
        String [] sub = new String[words.length];
        for (int i = 0; i <words.length; i++) {
            String w = words[i];
            for (int j = 0; j < w.length(); j++) {
//                w.charAt(j)
            }
        }

        return false;
    }
}
