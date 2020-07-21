package com.carrywei.reflectdemo;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> pClass = Class.forName("Person");
            Person p = (Person) pClass.newInstance();
            p.desc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
