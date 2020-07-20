package com.carrywei.threadcoreknowledge.sixstates;

/**
 * Created by wushuwei on 2020/4/27.
 * 描述：
 */
public class BlockedWaitingTimedWaiting implements Runnable{

    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(1000);
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockedWaitingTimedWaiting blockedWaitingTimedWaiting = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(blockedWaitingTimedWaiting);
        thread1.start();

        Thread thread2 = new Thread(blockedWaitingTimedWaiting);
        thread2.start();
        Thread.sleep(10);
        // 当线程运行到被锁住的地方时，线程处于Blocked
        System.out.println(thread2.getState());
        // 线程处于定时休眠状态时，状态为TimedWaiting
        System.out.println(thread1.getState());

        // 线程执行wait方法时，线程处于wait状态
        Thread.sleep(2300);
        System.out.println(thread1.getState());

        System.out.println(thread2.getState());

        Thread.sleep(10);
        blockedWaitingTimedWaiting.notify();
        System.out.println(thread1.getState());
    }

}
