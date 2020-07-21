package com.carrywei.basiclearn.lang.inheritance;

/**
 * Created by wushuwei on 2020/7/13.
 * 描述：
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Size.SMALL.getAbbreviation()); // S
        System.out.println(Size.valueOf("LARGE")); // LARGE
        System.out.println(Enum.valueOf(Size.class, "SMALL")); // SMALL
        System.out.println(Size.SMALL.compareTo(Size.LARGE)); // -2

        System.out.println(Size.getByAbbreviation("M")); // MEDIUM

        System.out.println(Size.SMALL.ordinal()); // 0

        System.out.println(Size.EXTRA_LAGER == Size.getByAbbreviation("XL")); // true

    }
}
enum Size{
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LAGER("XL");

    private String abbreviation;

    Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public static Size getByAbbreviation(String abbreviation) throws RuntimeException{
        for (Size e : Size.values()) {
            if (e.getAbbreviation().equals(abbreviation)) {
                return e;
            }
        }
        throw new RuntimeException("Not Found Enum");
    }

}
