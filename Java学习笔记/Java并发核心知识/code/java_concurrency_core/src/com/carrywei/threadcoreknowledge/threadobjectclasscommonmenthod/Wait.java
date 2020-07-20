package com.carrywei.threadcoreknowledge.threadobjectclasscommonmenthod;

/**
 * Created by wushuwei on 2020/4/27.
 * 描述：
 */
public class Wait {
    public static final Object lockObject = new Object();

    static class WaitThread implements Runnable{
        @Override
        public void run() {
            synchronized (lockObject) {
                System.out.println(Thread.currentThread().getName() + "已经获得锁，开始执行");
                try {
                    lockObject.wait();
                    System.out.println(Thread.currentThread().getName() + "开始重新获得锁，并睡眠1 s");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class NotifyThread implements Runnable{
        @Override
        public void run() {
            synchronized (lockObject) {
                System.out.println(Thread.currentThread().getName() + "已经获得锁，开始通知其他线程");
                lockObject.notify();
                try {
                    System.out.println("已通知完毕，休息5s");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class CommonLockThread implements Runnable {
        @Override
        public void run() {
            synchronized (lockObject) {
                System.out.println(Thread.currentThread().getName() + "获得了锁");
            }
        }
    }

    /**
     * 当线程处于wait时被中断，此时线程不会直接抛出异常（因为此锁正被其他线程占用，不能响应中断）。重新获得锁时，此线程为中断状态
     */
    static class InterruptWaitThread implements Runnable {
        @Override
        public void run() {
            synchronized (lockObject) {
                System.out.println(Thread.currentThread().getName() + "获得了锁");
                try {
                    lockObject.wait();
                    System.out.println("等待唤醒，此时中断状态：" + Thread.currentThread().isInterrupted());
                    System.out.println(Thread.currentThread().getName() + "已等待结束被唤醒");
                } catch (InterruptedException e) {
                    System.out.println("我被中断了");
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread waitThread1 = new Thread(new WaitThread(), "等待线程1");
        Thread waitThread2 = new Thread(new WaitThread(), "等待线程2");
        Thread notifyThread = new Thread(new NotifyThread(), "通知线程");
        Thread commonLockThread = new Thread(new CommonLockThread(), "普通加锁线程");
        Thread interruptWaitThread = new Thread(new InterruptWaitThread(), "中断等待线程");
//        waitThread1.start();
//        waitThread2.start();
//        Thread.sleep(100);
//        notifyThread.start();
//        commonLockThread.start();
        // 测试wait被中断时相应
        interruptWaitThread.start();
        Thread.sleep(100);
        notifyThread.start();
        Thread.sleep(200);
        System.out.println("准备中断线程");
        interruptWaitThread.interrupt();
    }
}
