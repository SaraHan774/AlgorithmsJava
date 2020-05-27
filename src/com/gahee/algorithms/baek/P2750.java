package com.gahee.algorithms.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P2750 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//이렇게 int 값 하나 받는 경우에는 그냥 Scanner 로 받자.

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }
//        arrayList.sort((o1, o2) -> {
//            if(o1 > o2){
//                return 1;
//            }else if(o1.equals(o2)){
//                return 0;
//            }
//            return -1;
//        });
        //굳이 Comparator 를 사용할 필요는 없었다.

        Collections.sort(arrayList);
        //Collections.sort 는 머지소트를 이용하므로 NlogN 의 성능이다.

        for (Integer integer : arrayList) {
            System.out.println(integer);
        }

        br.close();
    }
}

class OtherAnswer{

    public void solution(int [] arr){
        //array 가 들어오면 O(N^2) 의 성능으로 sorting 하기
        //버블 소트
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                //배열의 맨 뒤는 정렬이 되므로 arr.length - i 만큼만 반복한다.
                if(arr[j-1] > arr[j]){
                    //앞에 있는게 더 크면 뒤로 보낸다.
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                //정렬된 뒷부분을 만날때까지 이 과정을 반복한다.
            }
        }
    }
}
