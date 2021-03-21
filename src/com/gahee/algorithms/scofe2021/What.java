package com.gahee.algorithms.scofe2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class What {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String nums = br.readLine();
        int N = Integer.parseInt(nums.split(" ")[0]);
        int M = Integer.parseInt(nums.split(" ")[1]);

        PriorityQueue<Content> pq = new PriorityQueue<>();
        Content content = new Content();

        HashMap<Character, Double> rates = new HashMap<>();
        String [] r = input.split(" ");
        rates.put('A', Double.parseDouble(r[0]));
        rates.put('B', Double.parseDouble(r[1]));
        rates.put('C', Double.parseDouble(r[2]));
        rates.put('D', Double.parseDouble(r[3]));
        rates.put('E', Double.parseDouble(r[4]));

        for (int i = 0; i < N; i++) {
            char[] f = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {

            }
        }
    }

    static class Content implements Comparable<Content>{
        double rate;
        int x;
        int y;
        char genre; //A ... E
        Status status; //Y > O > W (x)

        @Override
        public int compareTo(Content content) {
            int s = this.status.compareTo(content.status);
            if(s > 0){
                return 1;
            }else if(s < 0){
                return -1;
            }else{
                int r = Double.compare(this.rate, content.rate);
                if(r == 0){
                    int yp = Integer.compare(this.y, content.y);
                    if(yp == 0){
                        return Integer.compare(this.x, content.x);
                    }else{
                        return yp;
                    }
                }else{
                    return r;
                }
            }
        }
    }

    class Status implements Comparable<Status>{
        char status;

        @Override
        public int compareTo(Status o) {
            if(this.status == o.status){
                return 0;
            }else if(this.status == 'Y'){
                return 1;
            }else if(this.status == 'O'){
                if(o.status == 'W'){
                    return 1;
                }else{
                    return -1;
                }
            }else if(this.status == 'W'){
                return -1;
            }
            return 0;
        }
    }
}
