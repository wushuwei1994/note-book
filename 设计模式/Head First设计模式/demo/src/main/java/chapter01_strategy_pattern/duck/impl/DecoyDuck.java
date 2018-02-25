package chapter01_strategy_pattern.duck.impl;

import chapter01_strategy_pattern.behavior.impl.FlyNoWay;
import chapter01_strategy_pattern.behavior.impl.MuteQuack;
import chapter01_strategy_pattern.duck.Duck;

/**
 * 诱饵鸭，不会飞不会叫
 */
public class DecoyDuck extends Duck {

    public DecoyDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    @Override
    public void display() {
        System.out.println("我是徒有其表鸭");
    }
}
