package com.carrywei.singleton;

/**
 * Created by wushuwei on 2020/5/19.
 * 描述：懒汉式（线程不安全）
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {
        System.out.println("实例化单例");
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
