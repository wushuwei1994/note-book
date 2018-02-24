package chapter01.behavior.impl;

import chapter01.behavior.FlyBehavior;

/**
 * 具体的“飞”行为类，实现“飞”行为，而此行为就是不会飞
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("我不会飞");
    }
}
