package com.carrywei.basiclearn.lang.generic;

import com.carrywei.basiclearn.lang.inheritance.Employee;

/**
 * Created by wushuwei on 2020/7/26.
 * 描述：
 */
public class GenericClass <T extends Object> {
    public static void main(String[] args) {
        GenericClass<Object> obj = new GenericClass<>();
    }

}
