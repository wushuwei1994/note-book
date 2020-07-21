package com.carrywei.basiclearn.obj;

/**
 * Created by wushuwei on 2020/7/10.
 * 描述：
 */
public class SubClass1 extends SuperClass {
    public SubClass1() {
        super("子类初始化父类构造器");
        System.out.println("子类构造器会不会调用父类构造器呢");

    }

    public static void main(String[] args) {
        new SubClass1();
        new SubClass1();

    }
}
