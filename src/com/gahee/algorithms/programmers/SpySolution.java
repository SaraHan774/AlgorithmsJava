package com.gahee.algorithms.programmers;

import java.util.HashMap;

public class SpySolution {

    private int answer = 0;

    public int solution(String[][] clothes) {
        answer = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String a = clothes[i][0];
            String b = clothes[i][1];
            int count = 1;
            if(map.containsKey(b)){
                count = map.get(b);
                map.put(b, ++count);
            }else{
                map.put(b, count);
            }
        }

        int total = map.size();
        int [] arr = new int[total];
        int i = 0;
        for (Integer value : map.values()) {
            arr[i++] = value;
        }

        int p = 1;
        boolean [] visited = {false, false, false};

        for (int k = 1; k <= arr.length; k++) {
            //    System.out.println("\n" + arr.length + " 개 중에서 " + k + " 개 뽑기");
            answer = combination(arr, visited, 0, arr.length, k);
        }
        return answer;
    }

    int combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            int sum = getSum(arr ,visited, n);
            answer += sum;
            return answer;
        }

        for(int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
        return answer;
    }

    int getSum(int[] arr, boolean[] visited, int n) {
        int sum=0;
        int mul=1;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                //System.out.print(arr[i]);
                mul*=arr[i];
            }
        }
        sum+=mul;
        return sum;
    }
}
