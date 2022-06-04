package com.gahee.algorithms.stepbystep.step3;

import java.io.*;

public class P11021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String [] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            bw.write("Case #" + (i + 1) + ": " + (a + b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
