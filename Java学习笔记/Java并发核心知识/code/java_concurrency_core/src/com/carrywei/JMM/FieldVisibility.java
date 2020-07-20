package com.carrywei.JMM;

/**
 * Created by wushuwei on 2020/5/11.
 * 描述：
 */
public class FieldVisibility {
    int a = 1;
    int b = 2;

    private void change() {
        a = 3;
        b = a;
    }

    private void print() {
        System.out.println("b = " + b + ", a = " + a);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i ++) {
            FieldVisibility fieldVisibility = new FieldVisibility();
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
////                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    fieldVisibility.print();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
//                    try {
////                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    fieldVisibility.change();
                }
            }).start();
        }
    }
}
