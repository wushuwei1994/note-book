package com.carrywei.basiclearn.obj;

/**
 * Created by wushuwei on 2020/7/10.
 * 描述：
 */
public class SuperClass {
    static{
        System.out.println("abc");
    }
    public SuperClass() {
        System.out.println("父类");
    }

    public SuperClass(String a) {
        System.out.println(a);
    }
}
