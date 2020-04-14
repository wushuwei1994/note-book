package com.carrywei.set;

import com.carrywei.tree.BST;

import java.util.Arrays;

/**
 * 以二分搜索树为底层实现集合
 * Created by 吴蜀威 on 2020/3/21.
 */
public class BSTSet<T extends Comparable<T>> implements Set<T> {

    private BST<T> data;

    public BSTSet() {
        data = new BST<>();
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
        data.remove(e);
    }

    @Override
    public void add(T e) {
        data.add(e);
    }

    @Override
    public boolean contains(T e) {
        return data.contains(e);
    }

    public static void main(String[] args) {
        BSTSet set = new BSTSet();
        String[] testData = {"a", "b", "c", "d", "b"};
        for (String s : testData) {
            set.add(s);
        }
        System.out.println("set size : " + set.getSize());
        System.out.println("set contains 'a'," + set.contains("a"));
        System.out.println("set contains 'e'," + set.contains("e"));
        set.remove("b");
        System.out.println("set size : " + set.getSize());
    }
}
