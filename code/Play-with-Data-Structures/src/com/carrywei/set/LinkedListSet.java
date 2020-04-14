package com.carrywei.set;

import com.carrywei.linkedlist.LinkedList;

/**
 * 以链表为底层实现集合
 * Created by 吴蜀威 on 2020/3/21.
 */
public class LinkedListSet<T> implements Set<T>{
    private LinkedList<T> data;

    public LinkedListSet() {
        data = new LinkedList<>();
    }
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int getSize() {
        return data.getSize();
    }

    @Override
    public void remove(T e) {
        data.removeElement(e);
    }

    @Override
    public void add(T e) {
        if (!data.contains(e)) {
            data.addFirst(e);
        }
    }

    @Override
    public boolean contains(T e) {
        return data.contains(e);
    }
}
