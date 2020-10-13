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
        String [] words = {"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"};
        String order = "zkgwaverfimqxbnctdplsjyohu";

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
            int len = Math.min(first.length, second.length);

            for (int j = 0; j < len; j++) {
                if(hashMap.get(first[j]) < hashMap.get(second[j])){
                    return true;
                }
                else if(hashMap.get(first[j]) == hashMap.get(second[j])){
                    continue;
                }else{
                    return false;
                }
            }

            if(first.length <= second.length){
                return true;
            }
        }
        return false;
    }
}
