package com.carrywei.set;

/**
 * 集合接口
 */
public interface Set<T> {

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 集合大小
     * @return
     */
    int getSize();

    /**
     * 从集合移除元素
     * @param e
     */
    void remove(T e);

    /**
     * 增加元素
     * @param e
     */
    void add(T e);

    /**
     * 是否包含元素
     * @param e
     * @return
     */
    boolean contains(T e);
}
