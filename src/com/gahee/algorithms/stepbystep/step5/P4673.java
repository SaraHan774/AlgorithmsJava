package com.gahee.algorithms.stepbystep.step5;

public class P4673 {

    public static void main(String[] args) {
        int [] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            int k = constFunc(i); // i = 33, consFunc(33) = 39
            if (k >= 10000) continue;
            else {
                arr[k] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == 0) continue;
            if (arr[i] != -1) {
                System.out.println(i);
            }
        }
    }

    static int constFunc(int n){
        String ns = String.valueOf(n);
        char [] chars = ns.toCharArray();
        int result = n;
        for (int i = chars.length - 1; i >= 0; i--) {
            int k = Character.getNumericValue(chars[i]); // 큰 자릿수 부터 꺼내오기
            result += k;
        }
        return result;
    }
}
