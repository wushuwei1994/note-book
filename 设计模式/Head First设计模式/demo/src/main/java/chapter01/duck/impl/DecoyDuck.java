package chapter01.duck.impl;

import chapter01.behavior.impl.FlyNoWay;
import chapter01.behavior.impl.MuteQuack;
import chapter01.duck.Duck;

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
