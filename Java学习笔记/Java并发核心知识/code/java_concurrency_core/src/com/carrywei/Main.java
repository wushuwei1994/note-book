package com.carrywei;

public class Main {
    private static class Task implements Runnable {
        int a;

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                this.a++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("result:" + task.a);
    }
}
