package pattern.abstract_factory;

/**
 * 工厂1
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/28 17:50
 */
public class Factory1 implements AbstractFactory {
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
