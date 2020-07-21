package com.carrywei.java8.passingcodewithbehaviorparam.predicate;

import com.carrywei.java8.passingcodewithbehaviorparam.Apple;

public class RedApplePredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor());
    }
}
