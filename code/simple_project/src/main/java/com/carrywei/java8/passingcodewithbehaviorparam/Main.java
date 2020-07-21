package com.carrywei.java8.passingcodewithbehaviorparam;

import com.carrywei.java8.passingcodewithbehaviorparam.predicate.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        String[] colors = {"red", "blue", "green", "white"};
        for (int i = 0; i < 100; i++) {
            Apple apple = new Apple(new Random().nextInt(200), colors[new Random().nextInt(colors.length)]);
            inventory.add(apple);
        }
        List<Apple> redApples = AppleUtils.filterApples(inventory, new RedApplePredicate());
        List<Apple> redBigApples = AppleUtils.filterApples(redApples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 10;
            }
        });


        List<Apple> redSmallApples = AppleUtils.filterApples(redApples, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() < 10;
            }
        });

        AppleUtils.prettyPrintApple(redSmallApples, new AppleWeightShow());


        // Lambda表达式简化代码
        List<Apple> blueApples = AppleUtils.filterApples(inventory, (Apple apple) -> "blue".equals(apple.getColor()));



        AppleUtils.prettyPrintApple(blueApples, (Apple apple) -> "color: " + apple.getColor());

        List<Egg> eggInventory = new ArrayList<>();
        eggInventory.add(new Egg(10, "ccc"));
        eggInventory.add(new Egg(20, "duck"));
        List<Egg> duckEggs = CommonFilter.filter(eggInventory, new DuckEggPredicate());

        List<Apple> newRedApples = CommonFilter.filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        newRedApples.sort((Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());
        newRedApples.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        AppleUtils.prettyPrintApple(newRedApples, apple -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Apple[").append("color = ").append(apple.getColor()).append(", ")
                    .append("weight = ").append(apple.getWeight()).append("]");
            return sb.toString();
        });

//        Predicate<Integer> predicate = new Predicate(i -> {return true});
//        predicate.test(5);

    }
}
