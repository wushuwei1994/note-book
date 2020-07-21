package com.carrywei.java8.passingcodewithbehaviorparam;

import com.carrywei.java8.passingcodewithbehaviorparam.predicate.ApplePredicate;
import com.carrywei.java8.passingcodewithbehaviorparam.predicate.AppleShow;

import java.util.ArrayList;
import java.util.List;

public class AppleUtils {
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result =  new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleShow appleShow) {
        for (Apple apple : inventory) {
            String output = appleShow.show(apple);
            System.out.println(output);
        }
    }
}
