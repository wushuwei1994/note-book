package pattern.factory_method;

/**
 * 商品B工厂
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/27 17:59
 */
public class ProductBFactory implements Factory{
    public Product createProduct() {
        return new ProductB();
    }
}
