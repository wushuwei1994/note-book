package com.carrywei.map;

/**
 * Created by 吴蜀威 on 2020/3/31.
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyHead;
    private int size;

    private class Node{
        Node next;
        K key;
        V value;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }
    }

    public LinkedListMap() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
//        if (contains(key)) {
//            return false;
//        } else {
//            dummyHead.next = new Node(key, value, dummyHead.next);
//            size++;
//        }
//        return true;
        Node node = getNode(key);
        if(node == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            size ++;
        }
        else
            node.value = value;
    }

    @Override
    public V get(K key) {
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            if (cur.key.equals(key)) {
//                return cur.value;
//            }
//            cur = cur.next;
//        }
//        return null;
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public boolean contains(K key) {
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            if (cur.key.equals(key)) {
//                return true;
//            }
//            cur = cur.next;
//        }
//        return false;
        return getNode(key) != null;
    }

    @Override
    public void set(K key, V value) {
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            if (cur.key.equals(key)) {
//                cur.value = value;
//                return;
//            }
//            cur = cur.next;
//        }
//        throw new IllegalArgumentException("未找到对应的key");
        Node node = getNode(key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = value;
    }

    @Override
    public V remove(K key) {
        Node pre = dummyHead;
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                V value = pre.next.value;
                pre.next = pre.next.next;
                size--;
                return value;
            }
            pre = pre.next;
        }
        throw new IllegalArgumentException("未找到对应的key");
    }

    public static void main(String[] args) {
        Map linkedListMap = new LinkedListMap();
        linkedListMap.add("1", "吴蜀威");
        linkedListMap.add("2", "wushuwei");
        System.out.println("size = " + linkedListMap.getSize());
        System.out.println("contains 1 : " + linkedListMap.contains("1"));
        linkedListMap.set("2", "wsw");
        System.out.println("2 is : " + linkedListMap.get("2"));
        System.out.println("remove 2 : " + linkedListMap.remove("2"));
        System.out.println("size = " + linkedListMap.getSize());

    }
}
