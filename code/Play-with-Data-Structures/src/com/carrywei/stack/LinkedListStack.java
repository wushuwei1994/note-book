package com.carrywei.stack;

import com.carrywei.linkedlist.LinkedList;

/**
 * Created by 吴蜀威 on 2020/3/11.
 */
public class LinkedListStack<T> implements Stack<T>{
    private LinkedList<T> linkedList;

    public LinkedListStack() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(T e) {
        linkedList.addFirst(e);
    }

    @Override
    public T pop() {
        return linkedList.remove(0);
    }

    @Override
    public T peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("stack: size = %d\ntop [", linkedList.getSize()));
        for (int i = 0; i < linkedList.getSize(); i++) {
            res.append(this.linkedList.get(i));
            if (i != linkedList.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> arrayStack = new LinkedListStack<>();
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
