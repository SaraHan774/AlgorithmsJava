package com.gahee.algorithms.scofe2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Socar {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int N = Integer.parseInt(input);

        PriorityQueue<MyTime> startDates = new PriorityQueue<>((o1, o2) -> -o1.compareTo(o2));
        PriorityQueue<MyTime> endDates = new PriorityQueue<>();


        for (int i = 0; i < N; i++) {
            String [] timeRange = br.readLine().split("~");
            String [] start = timeRange[0].split(":");
            String [] end = timeRange[1].split(":");

            MyTime st = new MyTime(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
            MyTime et = new MyTime(Integer.parseInt(end[0]), Integer.parseInt(end[1]));

            startDates.add(st);
            endDates.add(et);
        }

        MyTime sd = startDates.poll();
        MyTime ed = endDates.poll();

        assert sd != null;
        assert ed != null;

        if(sd.compareTo(ed) >= 0){
            System.out.println(-1);
        }else{
            String s = sd.hour + ":" + sd.min;
            String e = ed.hour + ":" + ed.min;
            System.out.println(s + " ~ " + e);
        }
    }

    static class MyTime implements Comparable<MyTime>{
        int hour;
        int min;

        public MyTime(int hour, int min){
            this.hour = hour;
            this.min = min;
        }

        @Override
        public int compareTo(MyTime t) {
            int compH = Integer.compare(this.hour, t.hour);
            if(compH == 0){
                return Integer.compare(this.min, t.min);
            }else{
                return compH;
            }
        }
    }
}
