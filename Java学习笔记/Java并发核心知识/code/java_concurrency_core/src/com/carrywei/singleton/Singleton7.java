package com.carrywei.singleton;

/**
 * Created by wushuwei on 2020/5/22.
 * 描述：静态内部类实现
 */
public class Singleton7 {

    private Singleton7() {

    }

     private static class SingletonInstance{
        private static Singleton7 instance = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.instance;
    }
}
