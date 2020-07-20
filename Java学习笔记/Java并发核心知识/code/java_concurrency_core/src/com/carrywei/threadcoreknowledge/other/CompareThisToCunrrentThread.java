package com.carrywei.threadcoreknowledge.other;

/**
 * Created by wushuwei on 2020/4/25.
 * 描述：对比当前对象与当前线程是否相等。如果线程为继承Thread方式，则为ture。如果线程为实现Runnable接口方式，则编译出错，不能比较
 */
public class CompareThisToCunrrentThread extends Thread{
    @Override
    public void run() {
        System.out.println(this == Thread.currentThread());
    }

    public static void main(String[] args) {
        new CompareThisToCunrrentThread().start();
    }

}
