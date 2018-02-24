package chapter01.duck.impl;

import chapter01.behavior.impl.FlyWithWings;
import chapter01.behavior.impl.Quack;
import chapter01.duck.Duck;

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
