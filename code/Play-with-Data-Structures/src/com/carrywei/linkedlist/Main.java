package com.carrywei.linkedlist;

import java.util.Random;

/**
 * Created by 吴蜀威 on 2020/3/10.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            int data = new Random().nextInt(10);
            System.out.println("add: " + data);
            //linkedList.add(i, new Random().nextInt(5));
            linkedList.addLast(data);
            System.out.println(linkedList);
        }
        System.out.println(linkedList.remove(3));
        System.out.println("end");
        linkedList.removeElement(3);
        System.out.println(linkedList);



    }
}
