package com.carrywei.threadcoreknowledge.startthread;

/**
 * Created by wushuwei on 2020/4/20.
 * 描述：重复启动线程，将会抛出 IllegalThreadStateException。因为线程启动会检查线程状态
 */
public class CantStartTwice extends Thread{
    @Override
    public void run() {
        System.out.println("线程启动");
    }

    public static void main(String[] args) {
        Thread thread = new CantStartTwice();
        thread.start();
        thread.start();
    }
}
