package com.carrywei.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * Created by wushuwei on 2020/5/19.
 * 描述：测试单例模式
 */
public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("开始");
//        Singleton1 singleton1 = Singleton1.getInstance();
//        Singleton1 singleton1_1 = Singleton1.getInstance();

//        Singleton2 singleton2 = Singleton2.getInstance();

        // 懒汉式单例模式，单线程情况不会出现线程安全问题(只会打印一次实例化信息)
//        for (int i = 0; i < 100; i++) {
//            Singleton3 singleton3 = Singleton3.getInstance();
//        }
        // 懒汉式单例模式，多线程情况会出现线程安全问题(多次打印实例化信息)
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
//                try {
//                    countDownLatch.await();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                Singleton3 singleton3 = Singleton3.getInstance();
            }).start();
//            countDownLatch.countDown();
        }

        // 枚举类实现方式
        Singleton8.INSTANCE.whatever();
    }

}
