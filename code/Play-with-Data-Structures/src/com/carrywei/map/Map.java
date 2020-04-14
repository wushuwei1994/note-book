package com.carrywei.map;

/**
 * map接口
 */
public interface Map<K, V> {
    int getSize();
    boolean isEmpty();
    void add(K key, V value);
    V get(K key);
    boolean contains(K key);
    void set(K key, V value);
    V remove(K key);
}
