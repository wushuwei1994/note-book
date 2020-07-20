package com.carrywei.singleton;

/**
 * Created by wushuwei on 2020/5/19.
 * 描述：饿汉式（静态常量）（可用）
 */
public class Singleton1 {

    private final static Singleton1 instance = new Singleton1();

    private Singleton1(){
        System.out.println("实例化单例");
    }

    public static Singleton1 getInstance() {
        return instance;
    }

}
