package com.carrywei.understanding.jvm.outofmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author wushuwei
 * @Description
 * @Date 2020/11/17
 **/
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;
    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        int i = 0;
        while (true) {
            System.out.println(i++);
            Thread.sleep(1000);
            unsafe.allocateMemory(_1MB);
        }
    }
}
