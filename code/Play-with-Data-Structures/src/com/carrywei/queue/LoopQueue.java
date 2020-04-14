package com.carrywei.queue;

/**
 * Created by 吴蜀威 on 2020/3/7.
 */
public class LoopQueue<T> implements Queue<T> {

    private T[] data;
    private int size;
    private int front; // 队首
    private int tail; // 队尾（入队时的位置）

    public LoopQueue(int capacity) {
        data = (T[]) new Object[capacity + 1];
        size = 0;
        front = 0;
        tail = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0; // 另一种写法：tail == front
    }

    @Override
    public void enqueue(T e) {
        if (size == data.length - 1) {
            // 扩容
            resize(2 * size + 1);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        T e = data[front];
        front = (front + 1) % data.length;
        size--;
        return e;
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }
        return data[front];
    }

    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i)%data.length];
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\nfront [", size, data.length - 1));
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(this.data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
