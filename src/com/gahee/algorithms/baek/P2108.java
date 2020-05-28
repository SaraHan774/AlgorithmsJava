package com.gahee.algorithms.baek;

import java.io.*;
import java.util.*;

public class P2108 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int [] arr = new int[N];

        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            sum += arr[i];

            if(map.containsKey(arr[i])){
                int val = map.get(arr[i]);
                map.put(arr[i], ++val);
            }else{
                map.put(arr[i], 1);
            }
        }

        //산술 평균
        if(sum < 0){
            bw.write((-1)*(int)Math.ceil(((float)Math.abs(sum))/(float)N) + "\n");
        }else{
            bw.write((int)Math.ceil(sum / N) + "\n");
        }

        //중앙값
        Arrays.sort(arr);
        bw.write(arr[N/2] + "\n");

        //최빈값
        int maxVal = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE; //만약 같은 횟수로 등장한 수가 여러개 있으면
        // 두번째로 작은 값을 출력해야 함.
        SortedSet<Integer> set = new TreeSet<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
//            System.out.println("key " + key + " val " + val);
            if(val > maxVal){
                maxVal = val;
                maxKey = key;
            }else if(val == maxVal){
                set.add(key);
                set.add(maxKey);
            }
//            System.out.println("max key = " + maxKey);
        }



        if(set.isEmpty()){
            bw.write(maxKey + "\n");
        }else {
            Iterator it = set.iterator();
            int count = 0;
            int [] sub = new int[set.size()];
            while(it.hasNext()){
                sub[count++] = (int) it.next();
            }
            bw.write(sub[1] + "\n");
        }


        //N 개의 수들 중 최댓값과 최솟값의 차이
        int k = arr[arr.length - 1] - arr[0];
        bw.write(k + "\n");

        bw.close();
        br.close();
    }
}
