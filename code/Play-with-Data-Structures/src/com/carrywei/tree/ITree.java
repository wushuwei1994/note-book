package com.carrywei.tree;

/**
 * Created by 吴蜀威 on 2020/3/12.
 */
public interface ITree<T> {
    int getSize();
    boolean isEmpty();
    T getRoot();
    T add(T e);
}
