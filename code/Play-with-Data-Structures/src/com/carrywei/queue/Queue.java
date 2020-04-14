package com.carrywei.queue;

/**
 * Created by 吴蜀威 on 2020/3/7.
 */
public interface Queue<T> {
    /**
     * 获取队列大小
     * @return
     */
    int getSize();

    boolean isEmpty();

    /**
     * 入队
     * @param e
     */
    void enqueue(T e);

    /**
     * 出队
     * @return
     */
    T dequeue();

    /**
     * 获取队首元素
     * @return
     */
    T getFront();
}
