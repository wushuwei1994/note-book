package com.carrywei.array;

/**
 * Created by 吴蜀威 on 2020/3/5.
 */
public class Student {
    private int age;
    private int score;

    public Student(int age, int score) {
        this.age = age;
        this.score = score;
    }
    @Override
    public  String toString() {
        return "student:age = " + age + ", score = " + score;
    }
}
