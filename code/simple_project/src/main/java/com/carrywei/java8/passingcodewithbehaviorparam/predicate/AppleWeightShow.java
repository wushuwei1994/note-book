package com.carrywei.java8.passingcodewithbehaviorparam.predicate;

import com.carrywei.java8.passingcodewithbehaviorparam.Apple;

import java.util.function.Predicate;

public class AppleWeightShow implements AppleShow {
    @Override
    public String show(Apple apple) {
        return "weight: " + apple.getWeight();
    }

    void test(Predicate predicate) {
        predicate.test("abc");
    }
}
