package com.carrywei.java8.streamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Trader james = new Trader("James", "Cambridge");
        Trader green = new Trader("Green", "Milan");
        Trader lopez = new Trader("Lopez", "Cambridge");
        Trader simon = new Trader("Simon", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(james, 2011, 300),
                new Transaction(green, 2012, 1000),
                new Transaction(green, 2011, 400),
                new Transaction(lopez, 2012, 710),
                new Transaction(lopez, 2012, 700),
                new Transaction(simon, 2012, 950)
        );

        /**
         *         (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
         *         (2) 交易员都在哪些不同的城市工作过
         *         (3) 查找所有来自于剑桥的交易员，并按姓名排序。
         *         (4) 返回所有交易员的姓名字符串，按字母顺序排序。
         *         (5) 有没有交易员是在米兰工作的？
         *         (6) 打印生活在剑桥的交易员的所有交易额。
         *         (7) 所有交易中，最高的交易额是多少？
         *         (8) 找到交易额最小的交易
         */
        // (1) 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> transactions2011 =  transactions
                .stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .collect(Collectors.toList());


        // (2) 交易员都在哪些不同的城市工作过
//        transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);
        transactions.stream().map(t -> t.getTrader().getCity()).collect(Collectors.toSet());

        // (3) 查找所有来自于剑桥的交易员，并按姓名排序。
        transactions.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(t -> t.getTrader())
                .distinct()
                .sorted(Comparator.comparing(Trader::getName)).forEach(System.out::println);

        // (4) 返回所有交易员的姓名字符串，按字母顺序排序。
//        String traderStr = transactions
//                .stream()
//                .map(t -> t.getTrader().getName())
//                .distinct()
//                .sorted(String::compareTo)
//                .reduce("", (n1, n2) -> n1 + n2);

        String traderStr = transactions
                .stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted(String::compareTo).collect(Collectors.joining());

        System.out.println(traderStr);

        // (5) 有没有交易员是在米兰工作的？
        System.out.println(transactions.stream().map(t -> t.getTrader().getCity()).anyMatch(s -> "Milan".equals(s)));
        System.out.println(transactions.stream().anyMatch(s -> "Milan".equals(s.getTrader().getCity())));

        // (6) 打印生活在剑桥的交易员的所有交易额。
        transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(t -> t.getValue()).forEach(System.out::println);

        // (7) 所有交易中，最高的交易额是多少？
        System.out.println(transactions.stream().max(Comparator.comparingInt(Transaction::getValue)).get().getValue());

        // (8) 找到交易额最小的交易
        System.out.println(transactions.stream().sorted(Comparator.comparingInt(Transaction::getValue)).findFirst().get());


    }
}
