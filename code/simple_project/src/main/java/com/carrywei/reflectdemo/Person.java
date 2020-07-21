package com.carrywei.reflectdemo;

public class Person {
    {
        System.out.println("Super static...");
    }
    public Person() {
        System.out.println("Person...");
    }

    public void desc() {
        System.out.println("Person obj");
    }
}
