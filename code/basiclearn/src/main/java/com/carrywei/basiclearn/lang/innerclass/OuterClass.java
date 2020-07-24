package com.carrywei.basiclearn.lang.innerclass;

/**
 * Created by wushuwei on 2020/7/22.
 * 描述：
 */
public class OuterClass {
    private int num = 5;

    public void test() {
        this.new InnerClass().method();
    }

    public class InnerClass{
        private int num = 6;
        private final static int num2 = 5;
        void method(){
            System.out.println("num = " + OuterClass.this.num);
        }
    }

    public static void main(String[] args) {
        new OuterClass().test();
        OuterClass outerClass = new OuterClass();
        (new OuterClass()).new InnerClass();
        outerClass.new InnerClass();

        new OuterClass().new InnerClass();

        new Thread(() -> {

        }).start();
    }
}
