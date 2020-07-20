package com.carrywei.threadcoreknowledge.stopthread;

/**
 * Created by wushuwei on 2020/4/25.
 * 描述：通过中断信号量来中断线程
 *
 */
public class StopThreadDemo1 implements Runnable{
    @Override
    public void run() {
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(i++);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThreadDemo1());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }


}
