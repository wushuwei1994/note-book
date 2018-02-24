package pattern.abstract_factory;

/**
 * 工厂2
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/28 17:51
 */
public class Factory2 implements AbstractFactory {
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
