package com.carrywei.queue;

/**
 * Created by 吴蜀威 on 2020/3/7.
 */
public class Main {
    public static void main(String[] args) {
//        Queue<Integer> arrayQueue = new ArrayQueue<Integer>();
//        for (int i = 0; i < 5; i++) {
//            arrayQueue.enqueue(i);
//            System.out.println(arrayQueue);
//        }
//        arrayQueue.dequeue();
//        System.out.println(arrayQueue);
//        arrayQueue.dequeue();
//        System.out.println(arrayQueue);

        //循环队列
//        Queue loopQueue = new LoopQueue<Integer>(3);
//        loopQueue.enqueue(2);
//        System.out.println(loopQueue);
//        loopQueue.dequeue();
//        System.out.println(loopQueue);
//
//        loopQueue.enqueue(5);
//        System.out.println(loopQueue);
//        loopQueue.enqueue(7);
//        System.out.println(loopQueue);
//        loopQueue.dequeue();
//        System.out.println(loopQueue);
//
//        loopQueue.enqueue(9);
//        System.out.println(loopQueue);
//        loopQueue.dequeue();
//        System.out.println(loopQueue);

        //链表队列
        Queue queue = new LinkedListQueue<Integer>();
        queue.enqueue(2);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);

        queue.enqueue(5);
        System.out.println(queue);
        queue.enqueue(7);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);

        queue.enqueue(9);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }
}
