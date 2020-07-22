package com.carrywei.basiclearn.lang.innerclass;

/**
 * Created by wushuwei on 2020/7/22.
 * 描述：
 */
public class OuterClass {
    private int num = 5;

    public void test() {
        new InnerClass().method();
    }

    class InnerClass{
        private int num1 = 6;

        void method(){
            System.out.println("num =" + num);
        }
    }

    public static void main(String[] args) {
        new OuterClass().test();
    }
}
