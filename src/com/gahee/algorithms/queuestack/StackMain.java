package com.gahee.algorithms.queuestack;

public class StackMain {

    public static void main(String[] args) {

        StackWithQueue stack = new StackWithQueue();

        stack.push(20);
        stack.push(14);
        stack.push(13);
        stack.push(11);
        stack.push(12);
        stack.printElements(stack.queue1, stack.queue2);

        stack.pop();

        stack.printElements(stack.queue1, stack.queue2);

        stack.pop();
        stack.printElements(stack.queue1, stack.queue2);

        stack.push(123);
        stack.push(234);
        stack.printElements(stack.queue1, stack.queue2);

        stack.pop();
        stack.printElements(stack.queue1, stack.queue2);

        stack.pop();
        stack.printElements(stack.queue1, stack.queue2);



    }
}
