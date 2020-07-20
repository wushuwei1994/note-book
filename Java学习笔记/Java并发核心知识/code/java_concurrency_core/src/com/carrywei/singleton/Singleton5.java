package com.carrywei.singleton;

/**
 * Created by wushuwei on 2020/5/21.
 * 描述：懒汉式（在singleton4基础上，缩小同步代码块范围；线程不安全；不推荐使用）
 */
public class Singleton5{

    private static Singleton5 instance;

    private Singleton5() {
        System.out.println("实例化单例");
    }

    public static synchronized Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
