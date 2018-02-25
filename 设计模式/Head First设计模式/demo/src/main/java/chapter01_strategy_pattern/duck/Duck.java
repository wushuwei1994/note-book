package chapter01_strategy_pattern.duck;

import chapter01_strategy_pattern.behavior.FlyBehavior;
import chapter01_strategy_pattern.behavior.QuackBehavior;

/**
 * 鸭子超类
 *
 */
public abstract class Duck {
    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;

    /**
     * 执行“飞”行为
     */
    public void performFly(){
        this.flyBehavior.fly();
    }

    /**
     * 执行“叫”行为
     */
    public void performQuack(){
        this.quackBehavior.quack();
    }

    /**
     * 动态设置“飞”行为
     * @param flyBehavior
     */
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }

    /**
     * 动态设置“叫”行为
     * @param quackBehavior
     */
    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    /**
     * 鸭子通用行为：游泳
     */
    public void swim(){
        System.out.println("游啊游...");
    }
    /**
     * 鸭子外形。每种类型鸭子外形不同，所以该方法是抽象的，由子类实现其不同的外形
     */
    public abstract void display();

}
