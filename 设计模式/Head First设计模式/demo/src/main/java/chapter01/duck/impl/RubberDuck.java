package chapter01.duck.impl;

import chapter01.behavior.impl.FlyNoWay;
import chapter01.behavior.impl.Squeak;
import chapter01.duck.Duck;

/**
 * 橡胶鸭，不具备飞的功能，只实现"叫"接口
 */
public class RubberDuck extends Duck {
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    @Override
    public void display() {
        System.out.println("我是橡胶鸭，不会飞");
    }
}
