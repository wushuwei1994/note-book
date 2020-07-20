package com.carrywei.singleton;

/**
 * Created by wushuwei on 2020/5/21.
 * 描述：双重检查；线程安全；效率较高
 */
public class Singleton6 {

    private volatile static Singleton6 instance;

    private Singleton6() {
        System.out.println("实例化单例");
    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
