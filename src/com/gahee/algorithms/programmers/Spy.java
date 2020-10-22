package com.gahee.algorithms.programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Spy {

    public static void main(String[] args) {
        String[][] test = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}, {"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        String [][] test1 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        SpySolution spySolution = new SpySolution();
        int result = spySolution.solution(test);

        System.out.println(result);
    }

}
