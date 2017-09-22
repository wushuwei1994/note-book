package pattern.builder;

/**
 * 套餐构建者
 *
 * @author 吴蜀威
 * @version V1.0  2017/8/3 16:03
 */
public interface MealBuilder {
    /**
     * 获取套餐
     * @return
     */
    Meal getMeal();

    void buildDrink();

    void buildFood();

}
