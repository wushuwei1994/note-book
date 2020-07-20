package com.carrywei.threadcoreknowledge.createthreads;

/**
 * Created by 吴蜀威 on 2020/4/15.
 * 描述：通过继承Thread类创建线程
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("继续Thread类创建线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
