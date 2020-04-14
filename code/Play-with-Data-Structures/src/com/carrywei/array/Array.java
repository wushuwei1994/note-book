package com.carrywei.array;

import java.util.Date;

/**
 * Created by 吴蜀威 on 2020/2/27.
 * 元素结构-动态数组
 */
public class Array<T> {
    private int size; // 数组大小
    private T[] data;

    /**
     * 有参构造函数
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        this.data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，数组容量默认为10
     */
    public Array() {
        this(10);
    }

    /**
     * 数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 数组大小
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 在数组最后一个元素添加新元素
     * @param e
     */
    public void addLast(T e) {
//        if (this.size == this.data.length) {
//            resize();
//        }
//        this.data[size] = e;
//        size++;
        add(size, e);
    }

    /**
     * 往数组指定位置添加元素
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        // 元素不合法
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        // 如果数组容量已满
        if (size == this.data.length) {
            resize(2 * this.data.length);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = e;
        size++;
    }

    /**
     * 在数组第一个位置添加元素
     * @param e
     */
    public void addFirst(T e) {
        add(0, e);
    }

    // 获取index索引位置的元素
    public T get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 修改index索引位置的元素为e
    public void set(int index, T e){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    /**
     * 删除指定位置元素
     * @param index
     * @return 返回移除的元素
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove failed. Require index >= 0 and index <= size.");
        }
        T ret = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return ret;
    }

    /**
     * 查找元素所在位置
     * @param e
     * @return
     */
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (this.data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查看数组是否包含此函数
     * @param e
     * @return
     */
    public boolean contains(T e) {
        int index = this.find(e);
        return index != -1;
    }

    /**
     * 移除某元素
     * @param e
     */
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public T removeFirst() {
        return remove(0);
    }

    /**
     * 数组扩容
     */
    private void resize(int newCapacity) {
        T[] newData =(T[]) new Object[newCapacity];
        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n[", size, data.length));
        for (int i = 0; i < size; i++) {
            res.append(this.data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<Student>(10);
        for (int i = 0; i < 10; i++) {
            arr.addLast(new Student(18, i));
        }
        System.out.println(arr);

        arr.addLast(new Student(19,100));
        System.out.println(arr);

        arr.remove(8);

        System.out.println(arr);
    }

}
