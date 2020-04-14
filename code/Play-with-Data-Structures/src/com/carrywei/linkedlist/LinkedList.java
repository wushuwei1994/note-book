package com.carrywei.linkedlist;

/**
 * Created by 吴蜀威 on 2020/3/10.
 */
public class LinkedList<T> {
    private class Node{
        public T e; //节点值
        public Node next;

        public Node(T e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        public Node(T e, Node next) {
           this.e = e;
           this.next = next;
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }

    /**
     * 虚拟头节点
     */
    private Node dummyHead;
    /**
     * 链表长度
     */
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在某个索引添加元素(上个节点的next指向新增节点，新增节点的next指向原index节点)
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        Node pre = this.dummyHead;
        // 找出index位置的上一节点
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 添加元素，递归实现
     * @param node
     * @param e
     */
    public Node addLast(Node node, T e) {
        if (node == null) {
            size++;
            return new Node(e);
        } else{
            node.next = addLast(node.next, e);
        }
        return node;
    }

    public void addFirst(T e) {
        add(0, e);
    }

    public void addLast(T e) {
        dummyHead.next = addLast(dummyHead.next, e);
        // 常规实现
//        add(size, e);
    }

    /**
     * 获取某个index 元素
     * @param index
     * @return
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    /**
     * 设置某个index 元素
     *
     * @param index
     * @return
     */
    public void set(int index, T e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(T e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (e == null) {
                if (cur.e == null) {
                    return true;
                }
            } else {
                if (e.equals(cur.e)) {
                    return true;
                }
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 移除某个元素
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("remove fail! Index  is illegal!");
        }
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node del = pre.next;
        pre.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(T e) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.e.equals(e)) {
                pre.next = pre.next.next;
                size--;
            } else {
                pre = pre.next;
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("LinkedList, size = %d\n", size));
        Node curNode = dummyHead.next;
//        for (int i = 0; i < size; i++) {
//            sb.append(curNode.e + " -> ");
//            curNode = curNode.next;
//        }
        while (curNode != null) {
            sb.append(curNode.e + " -> ");
            curNode = curNode.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
