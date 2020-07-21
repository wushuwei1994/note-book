package com.carrywei.util;

public class CommonUtils {
    public static int intRandom(int l, int r) {
        double d = Math.random() * (r - 1);
        return (int) d;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(CommonUtils.intRandom(0, 100));
        }
    }
}
