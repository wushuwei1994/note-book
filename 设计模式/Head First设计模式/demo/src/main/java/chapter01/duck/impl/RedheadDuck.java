package chapter01.duck.impl;

import chapter01.behavior.impl.FlyWithWings;
import chapter01.behavior.impl.Quack;
import chapter01.duck.Duck;

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
