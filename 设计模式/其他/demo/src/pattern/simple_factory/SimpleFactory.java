package pattern.simple_factory;

/**
 * 简单工厂模式：简单工厂
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/26 18:21
 */
public class SimpleFactory {

    public static final String PRODUCT_TYPE_A = "A";  //商品A类型
    public static final String PRODUCT_TYPE_B = "B";  //商品A类型

    public static Product createProduct(String type) {
        if (PRODUCT_TYPE_A.equals(type)) {
            return new ProductA();
        } else if (PRODUCT_TYPE_B.equals(type)) {
            return new ProductB();
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Product productA = (ProductA) SimpleFactory.createProduct(PRODUCT_TYPE_A);
        Product productB = (ProductB) SimpleFactory.createProduct(PRODUCT_TYPE_B);

        productA.methodA();
        productA.methodB();

        productB.methodA();
        productB.methodB();
    }
}
