package com.carrywei.threadcoreknowledge.uncaughtexception;

/**
 * Created by wushuwei on 2020/5/6.
 * 描述：
 */
public class UseOwnUncaughtExceptionHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("捕获到线程" + t.getName() + "异常");
//                e.printStackTrace();
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("发生异常啦");
            }
        }).start();

        throw new RuntimeException("主线程异常");
    }
}
