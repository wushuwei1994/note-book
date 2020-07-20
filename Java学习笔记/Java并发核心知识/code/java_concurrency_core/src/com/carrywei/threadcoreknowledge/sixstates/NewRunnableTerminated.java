package com.carrywei.threadcoreknowledge.sixstates;

/**
 * Created by wushuwei on 2020/4/27.
 * 描述：线程三种状态：New、Runnable、Terminated
 */
public class NewRunnableTerminated implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NewRunnableTerminated());
        // 创建线程，状态为New
        System.out.println(thread.getState());
        // 启动线程，状态Runnable
        thread.start();
        System.out.println(thread.getState());
        Thread.sleep(1000);
        // 线程终止，状态为Terminated
        System.out.println(thread.getState());
    }
}
