package com.gahee.algorithms.queuestack;

import java.util.EmptyStackException;
import java.util.Stack;


/*enque 는 왼쪽 스택에다가 계속 진행

deque 는 만약 오른쪽 스택이 비어있는 경우
왼쪽 스택이 다 빌때까지 pop 해서 오른쪽에다 넣고
가장 위에 있는 것을 pop 한다.

만약 오른쪽 스택이 비어있지 않다면
그냥 오른쪽 스택에 있는 것 중 가장 위의 원소를 pop 한다.*/

public class QueueWithStack {

    private Stack<Integer> stackLeft = new Stack<>();
    private Stack<Integer> stackRight = new Stack<>();

    //무조건 하나의 스택에만 enque를 한다.
    public void enque(int element){
        stackLeft.push(element);
        System.out.println("Enqued item : " + element);
    }

    public int deque(){
        if(stackLeft.isEmpty() && stackRight.isEmpty()) {
            System.out.println("Queue made with two stacks is empty!");
            throw new EmptyStackException();
        }
        //if there are elements in the left stack
        if(stackRight.isEmpty()) {
            while (!stackLeft.isEmpty()) {
                stackRight.push(stackLeft.pop());
            }
        }
        int popValue = stackRight.pop();
        System.out.println("Dequed item : " + popValue);
        return popValue;
    }

    public void printQueue(){
        System.out.println("\n === Queue total items === ");
        System.out.print("LEFT STACK => ");
        for(int item : stackLeft){
            System.out.print(item + " ");
        }
        System.out.print("RIGHT STACK => ");
        for(int item : stackRight){
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }
}
