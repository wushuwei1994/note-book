package com.carrywei.threadcoreknowledge.threadobjectclasscommonmenthod;

/**
 * Created by wushuwei on 2020/4/29.
 * 描述：打奇数偶数
 * */
public class WaitNotifyPrintOddEveWait implements Runnable{

    int count = 0;
    private static Object object = new Object();

    @Override
    public void run() {
        synchronized (object) {
            while (count <= 100) {
                System.out.println(Thread.currentThread().getName() + ":" + count);
                count++;
                try {
                    object.notify();
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        WaitNotifyPrintOddEveWait waitNotifyPrintOddEveWait = new WaitNotifyPrintOddEveWait();
        Thread thread1 = new Thread(waitNotifyPrintOddEveWait);
        Thread thread2 = new Thread(waitNotifyPrintOddEveWait);
        thread1.start();
        thread2.start();
    }
}
