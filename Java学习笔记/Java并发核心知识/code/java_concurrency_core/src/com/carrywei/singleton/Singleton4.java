package com.carrywei.singleton;

/**
 * Created by wushuwei on 2020/5/21.
 * 描述：懒汉式（创建实例静态方法增加同步代码块；线程安全；效率低；不推荐使用）
 */
public class Singleton4{

    private static Singleton4 instance;

    private Singleton4() {
        System.out.println("实例化单例");
    }

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
