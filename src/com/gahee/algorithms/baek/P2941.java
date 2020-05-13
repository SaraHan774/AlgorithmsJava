package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P2941 {

    public static void main(String[] args) throws IOException {

        //크로아티아 알파벳과 그에 해당하는 문자들
        //주어진 문자열에서 크로아티아 알파벳에 해당하는 문자가 몇개인지 출력하라.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //최대 100글자의 단어가 주어진다. 소문자, - , = 으로만 이루어짐.
        String input = br.readLine();

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("c=");
        arrayList.add("c-");
        arrayList.add("dz=");
        arrayList.add("d-");
        arrayList.add("lj");
        arrayList.add("nj");
        arrayList.add("s=");
        arrayList.add("z=");

        for (String s : arrayList){
            if(input.contains(s)){
                input = input.replaceAll(s, "!");
            }
        }
        System.out.println(input.length());

        br.close();
    }
}
