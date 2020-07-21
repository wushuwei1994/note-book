package com.carrywei.basiclearn.java8.stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/**
 * Created by wushuwei on 2020/6/3.
 * 描述：
 */
public class CollectMain {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "bb", "cc", "d");
        String result = list.stream().collect(joining(","));
        System.out.println(result);
        Map<Integer, List<String>> group = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(group);
    }
}
