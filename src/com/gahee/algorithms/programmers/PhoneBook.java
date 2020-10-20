package com.gahee.algorithms.programmers;

public class PhoneBook {
    //["12","123","1235","567","88"]
    //["123","456","789"] 한 번호가 다른 번호의 접두사인 경우가 없어야 true .
    public static void main(String[] args) {

        String [] pb = {"123","456","789"};
        boolean result = solution(pb);
        System.out.println(result);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        String k;
        for (int i = 0; i < phone_book.length; i++) {
            k = phone_book[i];
            for (int j = i + 1; j < phone_book.length; j++) {
                if(phone_book[j].contains(k)){
                    answer = false;
                    return answer;
                }
            }
        }
        return answer;
    }
}
