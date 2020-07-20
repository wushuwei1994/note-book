package com.carrywei.threadcoreknowledge.startthread;

import java.util.concurrent.TimeUnit;

/**
 * Created by wushuwei on 2020/4/25.
 * 描述：
 */
public class Test1 {
    static boolean isStop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!isStop) {
                    i++;
                    System.out.println("i:"+i);
                }
            }
        });
        newThread.start();
        TimeUnit.SECONDS.sleep(1);
        isStop = true;

    }
}

class Test2 implements Runnable {
    static boolean isStop = false;

    public static void main(String[] args) throws InterruptedException {
        Test2 instance = new Test2();
        Thread newThread = new Thread(instance);
        newThread.start();
        TimeUnit.SECONDS.sleep(1);
        isStop = true;
    }


    @Override
    public void run() {
        int i = 0;
        while (!isStop) {
            synchronized (this) {
                i++;
            }
        }
    }

}
