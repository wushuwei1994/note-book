package pattern.builder;

/**
 * KFC服务员
 *
 * @author 吴蜀威
 * @version V1.0  2017/8/3 16:05
 */
public class KFCWaiter {
    private MealBuilder mealBuilder;

    /**
     * 设置构建者
     * @param mealBuilder
     */
    public void setBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    /**
     * 构建食物
     * @return
     */
    public Meal construct(){
        this.mealBuilder.buildFood();
        this.mealBuilder.buildDrink();
        return mealBuilder.getMeal();
    }
}
