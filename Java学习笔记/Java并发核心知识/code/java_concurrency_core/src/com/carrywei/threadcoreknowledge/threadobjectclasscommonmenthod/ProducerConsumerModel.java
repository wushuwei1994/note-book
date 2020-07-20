package com.carrywei.threadcoreknowledge.threadobjectclasscommonmenthod;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by wushuwei on 2020/4/29.
 * 描述：
 */
public class ProducerConsumerModel {
    public static void main(String[] args) {
        Storage storage = new Storage(10);
        Thread producer = new Thread(new Producer(storage));
        Thread consumer = new Thread(new Consumer(storage));
        producer.start();
        consumer.start();
    }
}

/**
 * 仓库
 */
class Storage {
    private int maxSize;
    private LinkedList<Date> storage;

    public Storage(int maxSize) {
        storage = new LinkedList<Date>();
        this.maxSize = maxSize;
    }


    /**
     * 往仓库增加货物
     *
     * @param data
     */
    public synchronized void put(Date data) throws InterruptedException {
        /**
         * 当仓库满时，等待货物被取出
         */
        while (maxSize == storage.size()) {
            this.wait();
        }
        storage.add(data);
        System.out.println("已添加货物" + data);
        // 通知生产者已有货物
        this.notify();
    }

    /**
     * 从仓库取货物
     *
     * @param
     */
    public synchronized Date take() throws InterruptedException {
        /**
         * 当仓库没有货物时，等待货物添加
         */
        while (0 == storage.size()) {
            this.wait();
        }

        Date data = this.storage.poll();
        System.out.println("已取出货物：" + data);
        // 通知生产者仓库已有空闲
        this.notify();
        return data;
    }
}
    /**
     * 生产者
     */
    class Producer implements Runnable {
        Storage storage;
        public Producer(Storage storage) {
            this.storage = storage;
        }
        @Override
        public void run() {
            while (true) {
                Date data = new Date();
                try {
                    Thread.sleep(100);
                    storage.put(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Consumer implements Runnable {
        Storage storage;
        public Consumer(Storage storage) {
            this.storage = storage;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    storage.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
