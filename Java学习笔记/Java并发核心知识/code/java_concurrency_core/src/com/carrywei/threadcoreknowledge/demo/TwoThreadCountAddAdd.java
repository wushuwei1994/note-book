package com.carrywei.threadcoreknowledge.demo;

/**
 * Created by wushuwei on 2020/4/24.
 * 描述：
 */
public class TwoThreadCountAddAdd implements Runnable{
    int count;
    @Override
    public void run() {
        for(int i = 0; i < 10000; i++)
            count++;

    }

    public static void main(String[] args) throws InterruptedException {
        TwoThreadCountAddAdd twoThreadCountAddAdd = new TwoThreadCountAddAdd();
        Thread thread1 = new Thread(twoThreadCountAddAdd);
        Thread thread2 = new Thread(twoThreadCountAddAdd);
        thread1.start();
        thread2.start();
        thread1.join();
        thread1.join();
        System.out.println(twoThreadCountAddAdd.count);
    }
}
