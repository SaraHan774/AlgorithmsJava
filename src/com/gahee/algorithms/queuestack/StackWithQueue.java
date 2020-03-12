package com.gahee.algorithms.queuestack;


import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackWithQueue {

    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();


    public void push(int element){
        if(queue2.isEmpty()){
            queue1.add(element); //한 쪽에만 넣는다
        }else{
            queue2.add(element);
        }
    }

    public int pop(){
        if(queue1.isEmpty() && queue2.isEmpty()){
            throw new NoSuchElementException("Stack is Empty");
        }

        if(queue2.isEmpty()) { //만약 한 개 이상 인큐가 되어 있다면
            while (queue1.size() > 1) {
                queue2.add(queue1.remove());
            }
            return queue1.remove();

        }else{
            while (queue2.size() > 1){
                queue1.add(queue2.remove());
            }
            return queue2.remove();
        }
    }

    public void printElements(Queue<Integer> queue1, Queue<Integer> queue2){
        System.out.print("\nQueue 1 ==> ");
        for(Integer item : queue1){
            System.out.print(item + " ");
        }
        System.out.print("\nQueue 2 ==> ");
        for(Integer item : queue2){
            System.out.print(item + " ");
        }

        System.out.println("\nprinting finished!");
    }
}
