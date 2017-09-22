package pattern.factory_method;

/**
 * 商品A工厂
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/27 17:57
 */
public class ProductAFactory implements Factory {
    public Product createProduct() {
        return new ProductA();
    }
}
