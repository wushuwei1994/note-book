package com.carrywei.reflectdemo;

public class Man extends Person {
    {
        System.out.println("Man static...");
    }
    public Man() {
        System.out.println("Man...");
    }

    public void desc() {
        System.out.println("Man obj");
    }
}
