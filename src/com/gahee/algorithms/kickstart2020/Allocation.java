package com.gahee.algorithms.kickstart2020;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Allocation {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int T, B, N;
//        int [] prices;
        ArrayList<Integer> prices; 

        T = Integer.parseInt(st.nextToken());

        StringTokenizer st2;
        StringTokenizer st3;

        for(int i = 0; i < T; i++){
            st2 = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(st2.nextToken());
            B = Integer.parseInt(st2.nextToken());
            prices = new ArrayList<>();
//            System.out.printf("T %d B %d N %d : \n", T, B, N);

            st3 = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < N; j++){
                prices.add(Integer.parseInt(st3.nextToken()));
//                System.out.println(prices[j]);
            }
            bufferedWriter.write("Case #" + (i+1) + ": " + canBuy(prices, B) + "\n");
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static int canBuy(ArrayList<Integer> prices, int budget) {
        int buy = 0;
        int money = budget;
        Collections.sort(prices);
        for(int i = 0; i < prices.size(); i++){
            money = money - prices.get(i); //100 -20, 80 -90, 80 -40, 80 -90
               if(money >= 0){
                   buy++;
               }else{
                   money += prices.get(i);
               }
        }
        return buy;
    }
}
