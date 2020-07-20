package com.carrywei.threadcoreknowledge.createthreads;

/**
 * Created by 吴蜀威 on 2020/4/15.
 * 描述：通过实现Runnable接口方式创建线程
 */
public class RunnableStyle implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable方式创建线程");
    }

    public static void main(String[] args) {
        new Thread(new RunnableStyle()).start();
    }
}
