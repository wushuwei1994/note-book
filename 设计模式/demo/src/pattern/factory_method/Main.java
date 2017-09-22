package pattern.factory_method;

/**
 * Main方法
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/27 17:59
 */
public class Main {
    public static void main(String[] args) {
        Product productA = FactoryManager.getProductAFactory().createProduct();
        Product productB = FactoryManager.getProductBFactory().createProduct();
        productA.methodA();
        productA.methodB();
        productB.methodA();
        productB.methodB();
    }
}
