package com.gahee.algorithms.kickstart2020;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


/*2
2 4 5
10 10 100 30
80 50 10 50
3 2 3
80 80
15 50
20 10*/
public class Plates {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int T, N, K, P;

        T = Integer.parseInt(st.nextToken());

        StringTokenizer st2, st3;
        ArrayList<ArrayList<Integer>> plateStacks;
        ArrayList<Integer> stack;

        for(int i = 0; i < T; i++){
            st2 = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(st2.nextToken());
            K = Integer.parseInt(st2.nextToken());
            P = Integer.parseInt(st2.nextToken());
            int result = 0;
            plateStacks = new ArrayList<>();

            for(int j = 0; j < N; j++){
                //총 N개의 스택
                stack = new ArrayList<>();
                st3 = new StringTokenizer(bufferedReader.readLine());

                for(int k = 0; k < K; k++){
                    //하나의 스택마다 K개의 접시
                    stack.add(Integer.parseInt(st3.nextToken()));
                }
                plateStacks.add(stack);
            }
            //각 테스트 케이스 별 정답 출력
            result = getMax(plateStacks, P, K);
            bufferedWriter.write("Case #" + (i+1) + ": " + result);
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }

    private static int getMax(ArrayList<ArrayList<Integer>> stacks, int numPick, int stackHeight) {
        //num 개의 플레이트를 골라야 한다.

       return 0;
    }

}
