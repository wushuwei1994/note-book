package com.carrywei.queue;

import com.carrywei.linkedlist.LinkedList;

/**
 * Created by 吴蜀威 on 2020/3/11.
 */
public class LinkedListQueue<T> implements Queue<T> {
    /**
     * 内部类
     */
    private class Node{
        public T e;
        public Node next;

        public Node(T e) {
            this(e, null);
        }

        public Node(T e, Node next) {
            this.e = e;
            this.next = next;
        }
    }

    private int size;
    private Node front, tail;

    public LinkedListQueue() {
        size = 0;
        front = null;
        tail = null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T e) {
        // 如果队尾为空，则表示队列为空
        if (tail == null) {
            tail = new Node(e);
            front = tail;
        } else {
            Node newNode = new Node(e);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("Queue is empty");
        }
        T e = front.e;
        front = front.next;
        size--;
        // 栈为空时，队尾标识也需要重置为空
        if (size == 0) {
            tail = null;
        }
        return e;
    }

    @Override
    public T getFront() {
        return tail.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LinkedQueue, size = "+ size + "\nfront ");
        Node cur = front;
        while (cur != null) {
            sb.append(cur.e + "->");
            cur = cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }

}
