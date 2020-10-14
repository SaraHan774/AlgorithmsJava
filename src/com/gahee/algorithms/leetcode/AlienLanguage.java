package com.gahee.algorithms.leetcode;

import java.util.*;

public class AlienLanguage {

    public static void main(String[] args) {

        //["hello","leetcode"]
        //"hlabcdefgijkmnopqrstuvwxyz"

        //["word","world","row"]
        //"worldabcefghijkmnpqstuvxyz"

        //["fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"]
        //"zkgwaverfimqxbnctdplsjyohu"
        String [] words = {"hello","leetcode"};
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

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < orderArr.length; i++) {
            hashMap.put(orderArr[i], i);
        }

        for (int i = 0; i < words.length - 1; i++) {
            char [] first = words[i].toCharArray();
            char [] second = words[i + 1].toCharArray();

            boolean isRightOrder = compare(first, second, hashMap);
            if(!isRightOrder){
                return false;
            }
        }
        return true;
    }

    public static boolean compare(char [] first, char [] second, HashMap<Character, Integer> hashMap){
        int len = Math.min(first.length, second.length);

        for (int j = 0; j < len; j++) {
            //사전순이라는게 맨 앞의 글자부터 시작해서 빨리 판별되도록
            if(hashMap.get(first[j]) < hashMap.get(second[j])){
                return true;
            }
            else if(hashMap.get(first[j]) > hashMap.get(second[j])){
                return false;
            }
        }
        return first.length <= second.length;
    }
}
