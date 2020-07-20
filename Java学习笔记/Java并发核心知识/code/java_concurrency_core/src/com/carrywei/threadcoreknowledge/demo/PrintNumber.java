package com.carrywei.threadcoreknowledge.demo;

/**
 * Created by wushuwei on 2020/4/19.
 * 描述：
 */
public class PrintNumber {
    static int count = 0;
    static Object object = new Object();
    /**
     * 打印奇数
     */
    static class PrintEven extends Thread {
        @Override
        public void run() {
            while (count < 100) {
                synchronized (object) {
                    // 打印奇数
                System.out.println("奇数：" + count);
                    if ((count & 1) == 0) {
                        System.out.println(count);
                        count++;
//                        object.notify();
//                        try {
//                            object.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }
            }
        }
    }

    /**
     * 打印偶数
     */
    static class PrintOdd extends Thread {
        @Override
        public void run() {
            while (count < 100) {
                synchronized (object) {
                    // 打印偶数
                System.out.println("偶数：" + count);
                    if ((count & 1) == 1) {
                        System.out.println(count);
                        count++;
//                        object.notify();
//                        try {
//                            object.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintOdd printOdd = new PrintNumber.PrintOdd();
        PrintEven printEven = new PrintNumber.PrintEven();
        printOdd.start();
        printEven.start();
    }
}
