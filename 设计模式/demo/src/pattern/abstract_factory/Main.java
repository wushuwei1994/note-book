package pattern.abstract_factory;

/**
 * Main方法
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/28 17:53
 */
public class Main {
    public static void main(String[] args) {
        AbstractProductA productA1 = FactoryManager.getFactory1().createProductA();
        AbstractProductA productA2 = FactoryManager.getFactory2().createProductA();

        AbstractProductB productB1 = FactoryManager.getFactory1().createProductB();
        AbstractProductB productB2 = FactoryManager.getFactory2().createProductB();

        productA1.methodA();
        productA2.methodA();

        productB1.methodB();
        productB2.methodB();
    }
}
