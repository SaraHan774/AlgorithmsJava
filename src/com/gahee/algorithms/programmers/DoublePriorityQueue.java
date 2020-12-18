package com.gahee.algorithms.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    public static void main(String[] args) {
        //["I 7","I 5","I -5","D -1"]
        String [] test = {"I 7","I 5","I -5","D -1"};
        //["I 16","D 1"]
        String [] test2 = {"I 16","D 1"};

        int [] ans = solution(test2);
        System.out.println(Arrays.toString(ans));
    }

    private static int [] solution(String [] operations){
        int [] answer = new int[2];

        DEPQ depq = new DEPQ();

        for (int i = 0; i < operations.length; i++) {
            String [] cur = operations[i].split(" ");
            String operator = cur[0];
            if(operator.equals("D")){
                if(cur[1].equals("1")){
                    //최대값을 삭제하는 명령
                    depq.deleteMax();
                }else{
                    //D -1, 즉 최소값을 삭제하는 명령인 경우
                    depq.deleteMin();
                }
            }else{
                //숫자를 넣으라는 명령일것
                int operand = Integer.parseInt(cur[1]);
                depq.addElement(new Node(operand));
            }
        }

        answer[0] = depq.findMax();
        answer[1] = depq.findMin();

        return answer;
    }

    static class DEPQ{
        PriorityQueue<Node> minHeap;
        PriorityQueue<Node> maxHeap;

        public DEPQ(){
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>((node, t1) -> -Integer.compare(node.element, t1.element));
        }

        public void addElement(Node node){
            minHeap.add(node);
            maxHeap.add(node);
        }

        public int findMax(){
            if(maxHeap.size() > 0){
                return maxHeap.peek().element;
            }
            return 0;
        }

        public int findMin(){
            if(minHeap.size() > 0){
                return minHeap.peek().element;
            }
            return 0;
        }

        public void deleteMax(){
            if(maxHeap.size() > 0){
                int max = maxHeap.poll().element;
                minHeap.removeIf(cur -> cur.element == max);
            }
        }
    //빈 큐에 데이터를 삭제하라는 명령이 있으면 무시한다.
        public void deleteMin(){
            if(minHeap.size() > 0){
                int min = minHeap.poll().element;
                maxHeap.removeIf(cur -> cur.element == min);
            }
        }
    }

    static class Node implements Comparable<Node>{
        int element;
        public Node(int element){
            this.element = element;
        }

        @Override
        public int compareTo(Node o) {
            //reverse order
            return Integer.compare(this.element, o.element);
        }
    }
}
