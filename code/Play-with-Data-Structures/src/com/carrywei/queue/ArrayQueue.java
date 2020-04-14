package com.carrywei.queue;


import com.carrywei.array.Array;

/**
 * Created by 吴蜀威 on 2020/3/7.
 */
public class ArrayQueue<T> implements Queue<T> {

    private Array<T> data;

    public ArrayQueue(int capacity) {
        data = new Array<T>(capacity);
    }

    public ArrayQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        data.addLast(e);
    }

    @Override
    public T dequeue() {
        return data.removeFirst();
    }

    @Override
    public T getFront() {
        return data.get(0);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\nFront [", data.size(), data.getCapacity()));
        for (int i = 0; i < data.size(); i++) {
            res.append(this.data.get(i));
            if (i != data.size() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}
