package com.carrywei.threadcoreknowledge.other;

/**
 * Created by wushuwei on 2020/4/25.
 * 描述：
 */
public class RightWayStopThreadWithoutSleep implements Runnable{
    @Override
    public void run() {
        int num=0;
        int count=0;
        while(!Thread.currentThread().isInterrupted() && num<Integer.MAX_VALUE/2){
            if(num%10000==0){
                System.out.println(num+"是10000的倍数");
                count++;
            }
            num++;
        }
        System.out.println("任务运行结束了,运行次数为"+count);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(1);
        thread.interrupt();

        Thread.interrupted();
        thread.interrupted();
    }
}
