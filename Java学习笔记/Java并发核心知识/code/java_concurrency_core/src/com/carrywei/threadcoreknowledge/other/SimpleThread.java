package com.carrywei.threadcoreknowledge.other;

/**
 * Created by wushuwei on 2020/4/23.
 * 描述：
 */
public class SimpleThread implements Runnable {
    boolean flag;
    public static Object object1 = new Object();
    public static Object object2 = new Object();
    @Override
    public void run() {
        if (flag) {
            method1();
            method2();
        } else {
            method2();
            method1();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThread thread1 = new SimpleThread();
        SimpleThread thread2 = new SimpleThread();
        thread1.flag = true;
        new Thread(thread1, "线程1").start();
        Thread.sleep(100);
        thread2.flag = false;
        new Thread(thread2, "线程2").start();
    }

    public void method1() {
        synchronized(object1){
            System.out.println(Thread.currentThread().getName() + "-进入方法1,获得锁1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2) {
                System.out.println(Thread.currentThread().getName() + "-方法1,获得锁2");
            }
        }
        System.out.println(Thread.currentThread().getName() + "-退出方法1");
    }
    public  void method2() {
        synchronized(object2){
            System.out.println(Thread.currentThread().getName() + "-进入方法2,获得锁2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + "-方法2,获得锁1");
            }
        }
        System.out.println(Thread.currentThread().getName() + "-退出方法2");
    }
}
