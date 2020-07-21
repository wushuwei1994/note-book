package com.carrywei.basiclearn.obj;

/**
 * Created by wushuwei on 2020/5/27.
 * 描述：
 */
public class SubClass extends AbstractClass {
    public SubClass() {
        super("abc");
        System.out.println("子类");
    }

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
    }
}
