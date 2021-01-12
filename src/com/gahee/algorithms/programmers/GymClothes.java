package com.gahee.algorithms.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GymClothes {
    public static void main(String[] args) {
        int [] lost = {1, 2, 4, 5};
        int [] res = {2, 3, 4};
        System.out.println(solution(5, lost, res));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        List<Integer> reserveCopy = new ArrayList<>(reserveList.size());
        reserveCopy.addAll(reserveList);

        reserveList.removeIf(lostList::contains);
        lostList.removeIf(reserveCopy::contains);

        for(int i = 0; i < n; i++){
            int studNum = i + 1;
            boolean isLost = lostList.contains(studNum);
            boolean selfRes = reserveList.contains(studNum);
            if(isLost){
                System.out.println(studNum + " lost it");
                if(selfRes){
                    System.out.println("borrowed from self");
                    answer++;
                    reserveList.remove((Integer) studNum);
                }else{
                    boolean leftRes = reserveList.contains(studNum - 1);
                    boolean rightRes = reserveList.contains(studNum + 1);
                    if(leftRes){
                        System.out.println("borrowed from " + (studNum - 1));
                        reserveList.remove((Integer) (studNum - 1));
                        answer++;
                    }else if(rightRes){
                        System.out.println("borrowed from " + (studNum + 1));
                        reserveList.remove((Integer) (studNum + 1));
                        answer++;
                    }
                }
            }else{
                System.out.println(studNum + "'s not lost");
                answer++;
            }
        }

        return answer;
    }
}
