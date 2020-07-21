package com.carrywei.basiclearn.lang.inheritance;

/**
 * Created by wushuwei on 2020/7/12.
 * 描述：
 */
public class Manager extends Employee {
    private int award;
    private int sex = 0;

    public Manager() {

    }

    public Manager(String name, int salary, int award) {
        super(name, salary);
        this.award = award;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public static void main(String[] args) {
        Employee employee = new Manager();
        System.out.println(employee instanceof Employee); // true
        System.out.println(employee instanceof Manager); // true

        Employee employee1 = new Employee();
        System.out.println(employee1 instanceof Employee); // true
        System.out.println(employee1 instanceof Manager); //false

//        Manager[] staffs = new Manager[10];
//        Employee[] employees = staffs;
//        employees[0] = new Employee();

        Manager manager = new Manager();
        manager.testEex();
    }
}
