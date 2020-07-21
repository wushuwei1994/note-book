package com.carrywei.basiclearn.lang.datatype;

import java.util.Scanner;

/**
 * Created by wushuwei on 2020/7/11.
 * 描述：
 */
public class AboutString {
    public static void main(String[] args) {
        System.out.println("abcd".substring(2, 3)); //打印：c

        // 将字符数组拼接一起,结果为1|2|3
        System.out.println(String.join("|", new String[]{"1", "2" , "3"}));

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("ok! Your name is " + name);
    }
}
