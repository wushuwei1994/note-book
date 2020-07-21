package com.carrywei.basiclearn.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wushuwei on 2020/5/24.
 * 描述：
 */
public class StreamFirst {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("abc", "def", "ghii", "last");
//        list.stream().filter((s) -> {
//            System.out.println("in filter:" + s);
//            return s.length() > 0;
//        }).map((s) -> {
//            System.out.println("in map:" + s);
//            return s + ":map";
//        }).limit(3).collect(Collectors.toList());
        List<Integer> integers = Arrays.asList(1, 4, 5, 9);
        integers.stream().map(a -> a*a).forEach(System.out::println);

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<int[]> result = list1.stream().flatMap(i -> {
            return list2.stream().map(j -> new int[]{i, j});
        }).collect(Collectors.toList());
        result.stream().forEach(System.out::println);

        System.out.println(new int[]{1, 2});
//        System.out.println(result);
    }
}
