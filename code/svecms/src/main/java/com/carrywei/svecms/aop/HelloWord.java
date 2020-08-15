package com.carrywei.svecms.aop;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class HelloWord {
    public void sayHello(){
        System.out.println("hello world !");
    }
    public static void main(String args[]){
        HelloWord helloWord =new HelloWord();
        helloWord.sayHello();

        Set set1 = new TreeSet<>();
//
        set1.add(null);

        Set set2 = new HashSet();
        set2.add(null);

    }
}
