package pattern.builder;

/**
 * 套餐
 *
 * @author 吴蜀威
 * @version V1.0  2017/8/3 16:02
 */
public class Meal {
    /**
     * 饮料
     */
    private String drink;

    /**
     * 食物
     */
    private String food;

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void show(){
        System.out.println("drink : " + drink);
        System.out.println("food : " + food);
    }
}
