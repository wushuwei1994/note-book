package pattern.builder;

/**
 * B套餐构建者
 *
 * @author 吴蜀威
 * @version V1.0  2017/8/3 16:04
 */
public class MealBuilderB implements MealBuilder{

    private Meal meal;

    public MealBuilderB(){
        this.meal = new Meal();
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Meal getMeal() {
        this.buildDrink();
        this.buildFood();
        return this.meal;
    }

    public void buildDrink() {
        meal.setDrink("Drink B style");
    }

    public void buildFood() {
        meal.setFood("Food B style");
    }
}
