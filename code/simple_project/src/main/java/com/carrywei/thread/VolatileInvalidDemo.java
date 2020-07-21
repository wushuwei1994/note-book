package com.carrywei.thread;

public class VolatileInvalidDemo implements Runnable {
    volatile int count;
    private Object object = new Object();
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            // count++ => count = count; count = count + 1;
            synchronized (object){
                count++;;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileInvalidDemo volatileInvalidDemo = new VolatileInvalidDemo();
        Thread thread1 = new Thread(volatileInvalidDemo);
        Thread thread2 = new Thread(volatileInvalidDemo);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(volatileInvalidDemo.count);
    }
}
