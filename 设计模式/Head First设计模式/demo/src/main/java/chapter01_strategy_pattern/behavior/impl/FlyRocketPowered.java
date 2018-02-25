package chapter01_strategy_pattern.behavior.impl;

import chapter01_strategy_pattern.behavior.FlyBehavior;

/**
 * 具体的“飞”行为类，实现“飞”行为:火箭动力
 *
 */
public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("啾...（火箭声）");
    }
}
