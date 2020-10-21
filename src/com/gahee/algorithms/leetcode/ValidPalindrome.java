package com.gahee.algorithms.leetcode;

public class ValidPalindrome {
//https://leetcode.com/problems/valid-palindrome/

    public static void main(String[] args) {
        String test =  "A man, a plan, a canal: Panama";
        String test1 = "race a car";
        String test2 = "0P";
        boolean result = isPalindrome(test2);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        char[] lower = s.toLowerCase().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int ascii : lower) {
            //ascii 97 ... 122 , 48 ... 57
            if (ascii <= 122 && ascii >= 97) {
                stringBuilder.append((char) ascii);
            }else if(ascii >= 48 && ascii <= 57){
                stringBuilder.append((char)ascii); //numeric characters
            }
        }
//        System.out.println(stringBuilder);
        char[] s1 = stringBuilder.toString().toCharArray();
        int l = s1.length;

        if(l == 2){
            return s1[0] == s1[1];
        }
        for (int i = 0; i < l/2; i++) {
//            System.out.println(s1[i] + "/ " + s1[l - i - 1]);
            if (s1[i] != s1[l - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
