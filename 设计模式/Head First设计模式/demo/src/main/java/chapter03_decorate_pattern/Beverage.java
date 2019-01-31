package chapter03_decorate_pattern;

/**
 * 饮料父类
 */
public abstract class Beverage {
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract float cost();
}
