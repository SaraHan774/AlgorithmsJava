package com.gahee.algorithms.queuestack;

public class QueueMain {

    public static void main(String[] args) {

        QueueWithStack queue = new QueueWithStack();

        queue.enque(234);
        queue.enque(23);
        queue.enque(24);
        queue.enque(34);
        queue.enque(1004);
        queue.printQueue();

        queue.deque();
        queue.deque();
        queue.deque();
        queue.printQueue();

        queue.enque(23);
        queue.printQueue();

        queue.deque();
        queue.deque();
        queue.deque();
        queue.printQueue();
    }
}
