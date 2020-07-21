package com.carrywei.thread;

public class JoinTest implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("线程结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest joinTest = new JoinTest();
        Thread thread1 = new Thread(() ->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("等待线程1结束");
        thread1.join();
        System.out.println("线程1结束");
        thread2.join();
        System.out.println("线程2结束");
    }
}
