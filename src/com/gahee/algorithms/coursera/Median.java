package com.gahee.algorithms.coursera;

import java.io.*;
import java.util.PriorityQueue;

public class Median {

    private static final String FILE_PATH = "src\\com\\gahee\\algorithms\\coursera\\median.txt";
    private static int count = 0;

    public static void main(String[] args) {
        //median.txt maintenance 알고리즘을 구현하라.
        //1 ... 10_000까지의 정수가 담긴 파일,
        //하나씩 숫자가 들어온다고 할 때 10000개의 중간값을 다 더해서
        //이를 mod 10000 한 결과를 답안으로 작성하라.
        //홀수개의 숫자가 들어온 상태이면 k+1/2 번째로 작은 것이 중간이다.
        File file = new File(FILE_PATH);
        BufferedReader bufferedReader = null;
        String line;

        //max heap 에 작은 부분들을 담고 min heap 에 큰 부분들을 담는다.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1, o2));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //sum 을 계산하기 위한 변수
        int medianSum = 0;

        try {
            FileReader fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null){
                int x = Integer.parseInt(line);
                medianSum += findMedian(x, maxHeap, minHeap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(medianSum);
        System.out.println("answer = " + medianSum%10_000);

        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int findMedian(
            int x,
            PriorityQueue<Integer> maxHeap,
            PriorityQueue<Integer> minHeap) {


        int median = 0;

        if(count == 20){
            return median;
        }

        if(maxHeap.isEmpty()){
            maxHeap.add(x);
            median = x;
//            System.out.println("first = " + x);
            return median;
        }
        //그 다음부터는 min 과 max 두개의 숫자들을 비교해본다.
        if(minHeap.isEmpty()){
            int left = maxHeap.poll();
            if(x < left){
                maxHeap.add(x);
                minHeap.add(left);
            }else{
                maxHeap.add(left);
                minHeap.add(x);
            }
//            System.out.println("first second comparison ===> ");
            median = maxHeap.peek();
            return median;
        }else{
            int left = maxHeap.peek();
            if(x < left){
                maxHeap.add(x);
            }else{
                minHeap.add(x);
            }
            //두 개 heap 이 모두 차 있을 경우

//            System.out.println("\nbalancing ... ");
            if (maxHeap.size() != minHeap.size()) {
//                System.out.println("\nlength not equal ===> ");
                if (maxHeap.size() > minHeap.size()) {
                    minHeap.add(maxHeap.poll());
                }else {
                    maxHeap.add(minHeap.poll());
                }
            }
        }

//        System.out.println(maxHeap.size() + " left = " + maxHeap.peek());
//        System.out.println(minHeap.size() + " right = " + minHeap.peek());

        if(maxHeap.size() < minHeap.size()){
            median = minHeap.peek();
        }else if(maxHeap.size() > minHeap.size()){
            median = maxHeap.peek();
        }else{
            median = maxHeap.peek();
        }

//        System.out.println(median);

        return median;
    }
}
