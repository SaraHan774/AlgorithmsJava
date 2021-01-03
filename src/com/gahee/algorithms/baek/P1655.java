package com.gahee.algorithms.baek;

import java.io.*;
import java.util.PriorityQueue;

//가운데를 말해요
//Median Maintenece 문제
//min heap 과 max heap 두 개를 유지하면서 중간 값을 빠르게 반환할 수 있도록 한다.
//max heap 을 heapL 이라 하고, min heap 을 heapH 라고 부른다.
//heapL 의 최대값이 새로 들어온 숫자보다 크다면 해당 숫자는 heapH 로 들어가야한다.
public class P1655 {

    public static void main(String[] args) {
        //input 수빈이가 외치는 정수의 개수 N이 주어지고,
        //차례대로 해당 숫자들이 주어진다.

        //max heap
        PriorityQueue<Integer> heapL = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        //min heap
        PriorityQueue<Integer> heapH = new PriorityQueue<>();

        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try{
            N = Integer.parseInt(br.readLine());
            if(N == 1){
                bw.write(br.readLine());
                bw.flush();
                bw.close();
                br.close();
                return;
            }

            for (int i = 0; i < N; i++) {
                int cur = Integer.parseInt(br.readLine());
                if(i == 0){
                    //처음 들어오는 것은 무조건 low 에 넣기
                    heapL.add(cur);
                } else{
                    Integer h = heapH.peek();
                    //heapH 에 아무것도 들어있지 않는 경우
                    if(h == null){
                        //현재 들어온게 heapL 의 최대값보다 크면,
                        int l = heapL.poll();
                        if(cur > l){
                            heapH.add(cur);
                            heapL.add(l); //다시 넣어주기
                        }else{
                            heapH.add(l);
                            heapL.add(cur);
                        }
                    }else{
                        //들어있는 경우
                        int low = heapL.peek();
                        int high = heapH.peek();
                        if(cur <= high && cur > low){
                            heapL.add(cur);
                        }else if(cur < low){
                            heapL.add(cur);
                        }else{
                            heapH.add(cur);
                        }
                    }

                    //밸런싱하기
                    if(heapL.size() < heapH.size()){
                        int h1 = heapH.poll();
                        heapL.add(h1);
                    }else if(heapL.size() > heapH.size()){
                        int l1 = heapL.poll();
                        heapH.add(l1);
                    }
                }
                //만약 high 의 길이가 더 길 경우 high 의 root 를 정답으로 반환
                int answer;
                if(heapL.size() < heapH.size()){
                    answer = heapH.peek();
                }else{
                    answer = heapL.peek();
                }

                bw.write(answer + "\n");
//                System.out.println(answer);
//                System.out.println(heapL + " low = " + heapL.peek());
//                System.out.println(heapH + " high = " + heapH.peek());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            bw.flush();
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
/*
* 테스트 케이스
11
-10000
10000
100
-100
1
-1
-1
1
0
3
1
=========
* 정답
-10000
-10000
100
-100
1
-1
-1
-1
0
0
1
* */