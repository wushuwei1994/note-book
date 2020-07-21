package com.carrywei;

import com.carrywei.reflectdemo.Man;
import com.carrywei.reflectdemo.Person;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        Man man = new Man();
        try {
            Class<?> pClass = Class.forName("com.carrywei.reflectdemo.Person");
            Person p = (Person) pClass.newInstance();
            p.desc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
