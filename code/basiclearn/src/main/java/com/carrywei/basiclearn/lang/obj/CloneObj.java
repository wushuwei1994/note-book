package com.carrywei.basiclearn.lang.obj;

public class CloneObj implements Cloneable{
    int a = 5;

    public CloneObj clone() throws CloneNotSupportedException {
        return (CloneObj) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        CloneObj obj1 = new CloneObj();
        System.out.println(obj1.a);
        CloneObj obj2 = obj1.clone();
        System.out.println(obj2.a);
    }
}
