package com.gahee.algorithms.programmers;

public class PhoneBook {
    public static void main(String[] args) {
//["119", "97674223", "1195524421"] false !
        String [] pb = {"119", "97674223", "1195524421"};
        boolean result = solution(pb);
        boolean result2 = solution2(pb);
        System.out.println(result);
        System.out.println(result2);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        String k;
        for (int i = 0; i < phone_book.length; i++) {
            k = phone_book[i];
            int lenK = k.length();
            //처음부터 다 체크할 필요 없음 !
            // i + 1 부터 체크하는 대신에, i번째와 j 번째가
            //각자가 서로의 접두사가 되는지 확인하면 됨.
            for (int j = 0; j < phone_book.length; j++) {
                if(i == j){
                    continue;
                }
                String p = phone_book[j];
                int lenP = p.length();
                if(lenP >= lenK){
                    String pSub = p.substring(0, lenK);

                    if(pSub.equals(k)){
                        answer = false;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    public static boolean solution2(String [] phone_book){
        boolean answer = true;

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                //j 가 i 의 접두사가 되는가?
                if(phone_book[i].startsWith(phone_book[j])){return false;}
                //i 가 j의 접두사가 되는가?
                if(phone_book[j].startsWith(phone_book[i])){return false;}
            }
        }

        return answer;
    }
}
