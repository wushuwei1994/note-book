package com.carrywei.basiclearn.lang.generic;

/**
 * Created by wushuwei on 2020/7/26.
 * 描述：
 */
public class GenericMethod {
    public static <T> String getClassName(T clazz) {
        return clazz.getClass().getName();
    }

    public static void main(String[] args) {
        System.out.println(GenericMethod.getClassName("String"));
        System.out.println(GenericMethod.getClassName(1));
    }
}
