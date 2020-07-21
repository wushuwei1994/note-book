package com.carrywei.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("bcd");
        strings.add("abc");
        Object[] newStrings = (Object[]) strings.stream().filter(a -> a.equals("abc")).toArray();

        System.out.println(newStrings);
    }
}
