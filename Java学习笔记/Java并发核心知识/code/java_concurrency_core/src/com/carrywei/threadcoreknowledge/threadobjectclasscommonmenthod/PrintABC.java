package com.carrywei.threadcoreknowledge.threadobjectclasscommonmenthod;

/**
 * Created by wushuwei on 2020/4/29.
 * 描述：
 */
public class PrintABC {
    public static Object aLock = new Object();
    public static Object bLock = new Object();
    public static Object cLock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadB = new Thread(new PrintB());
        Thread threadA = new Thread(new PrintA());
        Thread threadC = new Thread(new PrintC());

        // 保证B线程先执行，进入阻塞状态，影响C线程不能获得锁
        threadB.start();
        Thread.sleep(1000);
        threadC.start();
        Thread.sleep(1000);
        threadA.start();
    }

}
class PrintA implements Runnable {

    @Override
    public void run() {
        while (true){
            synchronized (PrintABC.aLock) {
                synchronized (PrintABC.cLock) {
                    System.out.println("A");
                    PrintABC.aLock.notify();
                    try {
                        PrintABC.aLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class PrintB implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (PrintABC.aLock) {
                synchronized (PrintABC.bLock) {
                    try {
                        PrintABC.aLock.wait();
                        System.out.println("B");
                        PrintABC.cLock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class PrintC implements Runnable {
    @Override
    public void run() {
        while (true) {
            synchronized (PrintABC.bLock) {
                synchronized (PrintABC.cLock) {
                    try {
                        PrintABC.cLock.wait();
                        System.out.println("C");
                        PrintABC.aLock.notify();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}