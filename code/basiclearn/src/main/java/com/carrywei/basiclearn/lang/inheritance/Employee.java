package com.carrywei.basiclearn.lang.inheritance;

/**
 * Created by wushuwei on 2020/7/12.
 * 描述：
 */
public class Employee {
    private String name;
    private int salary;
    private int sex = 1;


    public Employee() {

    }

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void testEex() {
        System.out.println(sex);
    }

//    public abstract int getPerformance(); // 只有类声明了是abstract类型，其才能声明abstract方法
}
