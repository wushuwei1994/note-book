package com.carrywei.understanding.jvm.outofmemory;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author wushuwei
 * @Description
 * @Date 2020/11/16
 **/
public class RuntimeConstantPoolOOM {

    /**
     * 启动om参数设为 -Xms6m -Xmx6m，程序将报 Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
     */
    public static void test1(){
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }

    /**
     * Java7之后，字符串常量池放在堆内存
     */
    public static void test2() {
        String str1 = new StringBuilder("计算器").append("科学").toString();
        // true
        System.out.println(str1.intern() == str1);
        // false
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
