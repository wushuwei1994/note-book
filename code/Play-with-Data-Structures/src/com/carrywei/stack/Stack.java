package com.carrywei.stack;

/**
 * Created by 吴蜀威 on 2020/3/5.
 */
public interface Stack<T> {
    /**
     * 获取栈大小
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param e
     */
    void push(T e);

    /**
     * 出栈
     * @return
     */
    T pop();

    /**
     * 获取栈顶元素
     * @return
     */
    T peek();
}
