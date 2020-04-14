package com.carrywei.stack;

import com.carrywei.array.Array;

/**
 * Created by 吴蜀威 on 2020/3/5.
 */
public class ArrayStack<T> implements Stack<T> {

    private Array<T> data;

    public ArrayStack(int capacity) {
        this.data = new Array<T>();
    }

    public ArrayStack() {
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
    public void push(T e) {
        data.addLast(e);
    }

    @Override
    public T pop() {
        return data.removeLast();
    }

    @Override
    public T peek() {
        return data.get(data.size() - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("stack: size = %d, capacity = %d\n[", data.size(), data.getCapacity()));
        for (int i = 0; i < data.size(); i++) {
            res.append(this.data.get(i));
            if (i != data.size() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 11; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        System.out.println("stack top is : " + arrayStack.peek());

        for (int i = 0; i < 5; i++) {
            System.out.println("stack pop : " + arrayStack.pop());
            System.out.println(arrayStack);
        }
    }
}
