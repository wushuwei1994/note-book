package pattern.abstract_factory;

/**
 * 抽象工厂
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/28 17:48
 */
public interface AbstractFactory {
    AbstractProductA createProductA();

    AbstractProductB createProductB();

}
