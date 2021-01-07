package com.gahee.algorithms.programmers;

public class StringToNumber {

    public static void main(String[] args) {

        String t1 = "-1234";
        String t2 = "asbdf1234";
        String t3 = "+absdf1dsf3";

        //solution(t3);
        charTesting();
    }

    private static void solution(String t1) {
        char [] chars = t1.toCharArray();
        String buho = "";
        StringBuilder nums = new StringBuilder();
        for (char aChar : chars) {
            if(aChar == '-'){
                buho = "-";
            }else if(aChar == '+'){
                buho = "+";
            }else{
                if(Character.isDigit(aChar)){
                    //캐릭터가 digit 인지, alphanumric 인지 확인할 수 있는 메서드 있음.
                    nums.append(aChar);
                }
            }
        }
        System.out.println(buho + nums);
    }

    private static void charTesting(){
        String s = "av123er   tgs---1781920380r0((^^&*()=";
        char [] chars = s.toCharArray();
        for (char c : chars) {
            if(Character.isDigit(c)){
                System.out.println(c + " is digit");
            }
            else if(Character.isAlphabetic(c)){
                System.out.println(c + " is alphabet");
            }
            else if(Character.isSpaceChar(c)){
                System.out.println("space char");
            }
            else{
                System.out.println("what is this ? " + c);
            }
            if(Character.isLetterOrDigit(c)){
                System.out.println(c +  " is letter or digit");
            }
        }
    }
}
