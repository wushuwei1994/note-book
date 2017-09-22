package pattern.factory_method;

/**
 * 工厂管理类
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/27 18:02
 */
public class FactoryManager {
    private static ProductAFactory productAFactory;
    private static ProductBFactory productBFactory;

    public static ProductAFactory getProductAFactory(){
        if (productAFactory == null) {
            productAFactory = new ProductAFactory();
            return productAFactory;
        }else {
            return productAFactory;
        }
    }

    public static ProductBFactory getProductBFactory(){
        if (productBFactory == null) {
            productBFactory = new ProductBFactory();
            return productBFactory;
        }else {
            return productBFactory;
        }
    }
}
