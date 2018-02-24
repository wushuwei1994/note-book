package pattern.abstract_factory;

import pattern.factory_method.ProductAFactory;
import pattern.factory_method.ProductBFactory;

/**
 * 工厂管理类
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/27 18:02
 */
public class FactoryManager {
    private static Factory1 factory1;
    private static Factory2 factory2;

    public static Factory1 getFactory1(){
        if (factory1 == null) {
            factory1 = new Factory1();
            return factory1;
        }else {
            return factory1;
        }
    }

    public static Factory2 getFactory2(){
        if (factory2 == null) {
            factory2 = new Factory2();
            return factory2;
        }else {
            return factory2;
        }
    }
}
