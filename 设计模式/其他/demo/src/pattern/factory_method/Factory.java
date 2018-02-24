package pattern.factory_method;

/**
 * 工厂
 *
 * @author 吴蜀威
 * @version V1.0  2017/7/27 17:56
 */
public interface Factory {
    /**
     * 创建商品
     * @return
     */
    Product createProduct();
}
