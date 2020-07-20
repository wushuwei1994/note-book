package com.carrywei.threadcoreknowledge.other;

/**
 * Created by wushuwei on 2020/4/25.
 * 描述：获取线程结束之后是否为中断状态。结果为false
 */
public class GetInterruptedStateAfterThreadEnd implements Runnable{
    @Override
    public void run() {
        System.out.println("执行线程啦");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new GetInterruptedStateAfterThreadEnd());
        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        Thread.sleep(10);
        System.out.println(thread.isInterrupted());
    }
}
