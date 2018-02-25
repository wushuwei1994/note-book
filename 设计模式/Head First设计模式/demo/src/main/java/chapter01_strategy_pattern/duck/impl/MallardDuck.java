package chapter01_strategy_pattern.duck.impl;

import chapter01_strategy_pattern.behavior.impl.FlyWithWings;
import chapter01_strategy_pattern.behavior.impl.Quack;
import chapter01_strategy_pattern.duck.Duck;

/**
 * 绿头鸭
 */
public class MallardDuck extends Duck {
    public MallardDuck(){
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("我是绿头鸭");
    }
}
