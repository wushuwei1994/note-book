package pattern.builder;

/**
 * main
 *
 * @author 吴蜀威
 * @version V1.0  2017/8/3 16:29
 */
public class Main {
    public static void main(String[] args) {
        KFCWaiter waiter1 = new KFCWaiter();
        MealBuilder mealBuilderA = new MealBuilderA();
        MealBuilder mealBuilderB = new MealBuilderB();

        waiter1.setBuilder(mealBuilderA);
        Meal mealA = waiter1.construct();
        mealA.show();

        waiter1.setBuilder(mealBuilderB);
        Meal mealB = waiter1.construct();
        mealB.show();
    }
}
