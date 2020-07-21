package com.carrywei.basiclearn.lang.lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by wushuwei on 2020/7/15.
 * 描述：
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] strList = {"morning", "afternoon", "night"};
        System.out.println(Arrays.toString(strList));
        Arrays.sort(strList);
        System.out.println(Arrays.toString(strList));
        Arrays.sort(strList, (s1, s2) -> s1.length() - s2.length()); // 等价于 Arrays.sort(strList, Comparator.comparingInt(String::length));
//        Arrays.sort(strList, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(strList));

    }
}
