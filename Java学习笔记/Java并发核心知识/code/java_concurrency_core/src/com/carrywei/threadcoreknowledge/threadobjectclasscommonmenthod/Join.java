package com.carrywei.threadcoreknowledge.threadobjectclasscommonmenthod;

/**
 * Created by wushuwei on 2020/5/1.
 * 描述：
 */
public class Join implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Join());
        thread.start();
        thread.join();
        thread.yield();
        thread.yield();
        System.out.println("线程1已结束");
    }
}
