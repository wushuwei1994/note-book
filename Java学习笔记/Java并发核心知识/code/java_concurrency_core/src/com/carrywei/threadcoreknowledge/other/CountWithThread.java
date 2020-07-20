package com.carrywei.threadcoreknowledge.other;

/**
 * Created by wushuwei on 2020/4/25.
 * 描述：
 */
public class CountWithThread implements Runnable {
    static int count;
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountWithThread countWithThread = new CountWithThread();
        Thread thread1 = new Thread(countWithThread);
        thread1.start();
        Thread thread2 = new Thread(countWithThread);
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }

}

