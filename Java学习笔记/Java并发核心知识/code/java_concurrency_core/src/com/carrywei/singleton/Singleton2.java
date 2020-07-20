package com.carrywei.singleton;

/**
 * Created by wushuwei on 2020/5/19.
 * 描述：饿汉式（静态代码块）（可用）
 */
public class Singleton2 {

    private static final Singleton2 instance;

    static {
        instance = new Singleton2();
    }
    private Singleton2() {
        System.out.println("实例化单例");
    }

    public static Singleton2 getInstance() {
        return instance;
    }


}
