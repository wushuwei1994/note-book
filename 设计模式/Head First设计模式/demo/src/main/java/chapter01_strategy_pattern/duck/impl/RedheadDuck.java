package chapter01_strategy_pattern.duck.impl;

import chapter01_strategy_pattern.behavior.impl.FlyWithWings;
import chapter01_strategy_pattern.behavior.impl.Quack;
import chapter01_strategy_pattern.duck.Duck;

/**
 * 红头鸭，实现"飞"、"叫"接口
 */
public class RedheadDuck extends Duck{
    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("我是红头鸭");
    }

}
