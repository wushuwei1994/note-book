package chapter01_strategy_pattern.behavior.impl;

import chapter01_strategy_pattern.behavior.FlyBehavior;

/**
 * 具体的“飞”行为类，实现“飞”行为
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我有翅膀，可以飞得更高！");
    }
}
