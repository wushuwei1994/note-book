package com.carrywei.basiclearn.lang.inheritance;

public class Test {
    public static String getType(Employee employee) {
        return "employee";
    }

//    public String getType(Employee employee) {
//        return "employee";
//    }

    public static String getType(Manager manager) {
        return "manager";
    }

    public static void main(String[] args){
        Employee employee = new Manager();
        System.out.println(Test.getType(employee));
    }
}
