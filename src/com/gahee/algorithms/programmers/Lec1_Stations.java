package com.gahee.algorithms.programmers;

import java.util.Arrays;
//https://programmers.co.kr/learn/courses/10302/lessons/62946
//기지국 설치 문제
public class Lec1_Stations {

    public static void main(String[] args) {


    }

    //내가 풀다 만 코드
    //문제점 : 생각을 코드로 옮기는 과정에서 자신감이 없었다.
    public int solutionMine(int n, int[] stations, int w) {
        int answer = 0;

        boolean [] nums = new boolean [n];

        //기지국 설치를 boolean 배열로 나타내겠다는 생각이 잘못된 것
        //문제에서 물어보는건 결국 몇 개를 추가로 증설해야 하는지 인데,
        //물어보는 것에 초점을 맞춰서 코드를 구현해야 했다.
        for(int s : stations){
            int idx = s - 1;
            //stations 배열에 주어진 대로 영향 범위를 표시하는 것
            //이렇게 표시를 할 필요가 전혀 없는 곳에서 시간을 많이 잡아먹음
            for(int i = idx - w; i <= idx + w; i++){
                if(i >= 0 && i < n && !nums[i]){
                    nums[i] = true;
                }
            }
        }

        System.out.println(Arrays.toString(nums));

        // 기지국의 설치 개수를 세려고 했지만, 생각이 꼬이고 시간이 촉박해져서 포기함.
        for(int i = 0; i < n; i++){
            if(!nums[i]){
                answer++;
                for(int j = i; j < 2*w + 1; j++){
                    nums[j] = true;
                }
            }
        }

        System.out.println(Arrays.toString(nums));

        return answer;
    }

    private static int solutionOther(int n, int[] stations, int w){
        int answer = 0;
        int position = 1;
        int idx = 0;

        while(position <= n){
            //position increase condition
            if(idx < stations.length && position >= stations[idx] - w){
                position = stations[idx] + w + 1; // 마지막으로 영향 받는 곳 다음으로 점프
                idx++;
            }else{
                answer++;
                position += 2*w + 1;
            }
        }

        return answer;
    }
}
