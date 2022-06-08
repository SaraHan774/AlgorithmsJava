package com.gahee.algorithms.stepbystep.step6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2941 {

    public static void main(String[] args) throws IOException {
        String[] tokens = {
                "c=", "c-",
                "dz=", "d-",
                "lj", "nj",
                "s=", "z="
        }; // 여기 없는 알파벳은 할글자로 센다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (String token : tokens) {
            if (s.contains(token)) {
                s = s.replaceAll(token, ".");
            }
        }
        System.out.println(s.length());
    }
}
