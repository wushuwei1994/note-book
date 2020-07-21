package com.carrywei.basiclearn.java8.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by wushuwei on 2020/5/20.
 * 描述：
 */
public class AllFunctionalImpl {
    public static <T> List<T> filter(List<T> oldList, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T e : oldList) {
            if (predicate.test(e)) {
                newList.add(e);
            }
        }
        return newList;
    }

    public static <T> void output(List<T> list, Consumer<T> consumer) {
        for (T e : list) {
            consumer.accept(e);
        }
    }

    public static <T, R> List<R> convert(List<T> oldList, Function<T, R> function) {
        List<R> newList = new ArrayList<>();
        for (T e : oldList) {
            newList.add(function.apply(e));
        }
        return newList;
    }

    public static <T> T create(Supplier<T> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        List<String> oldStringList = new ArrayList<>();
        oldStringList.add("abc");
        oldStringList.add("123");
        oldStringList.add("a1b2c3");
        List<String> newStringList = filter(oldStringList, (String s) -> s.contains("a"));

        output(newStringList, (s) -> System.out.println(s) );


        List<Integer> newConvertStringList =convert(oldStringList, (s1) -> {
            return new Integer(s1.length());
        });

        output(newConvertStringList, (s) -> System.out.println(s) );

        oldStringList.add(create(() -> {
            return "abc";
        }));

        output(oldStringList, System.out::println);
    }


}
