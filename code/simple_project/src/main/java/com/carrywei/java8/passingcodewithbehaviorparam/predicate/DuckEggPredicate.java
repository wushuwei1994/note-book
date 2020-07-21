package com.carrywei.java8.passingcodewithbehaviorparam.predicate;

import com.carrywei.java8.passingcodewithbehaviorparam.Egg;

public class DuckEggPredicate implements Predicate<Egg> {
    @Override
    public boolean test(Egg egg) {
        return "duck".equals(egg.getType());
    }
}
