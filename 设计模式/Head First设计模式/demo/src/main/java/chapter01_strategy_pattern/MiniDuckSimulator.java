package chapter01_strategy_pattern;

import chapter01_strategy_pattern.behavior.impl.FlyRocketPowered;
import chapter01_strategy_pattern.duck.Duck;
import chapter01_strategy_pattern.duck.impl.MallardDuck;

/**
 * Created by 吴蜀威 on 2018/2/19.
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performFly();
        mallard.performQuack();
        // 动态改变飞行行为
        System.out.println("================动态改变飞行行为=================");
        mallard.setFlyBehavior(new FlyRocketPowered());
        mallard.performFly();
    }
}
