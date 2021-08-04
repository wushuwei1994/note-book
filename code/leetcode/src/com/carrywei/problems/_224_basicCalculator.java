package com.carrywei.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wushuwei on 2021/3/24.
 * 描述：224. 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 *
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */
public class _224_basicCalculator {
    public int calculate(String s) {
        // 思路：1.将字符串的数字部分拼接成正确的数字
        /**
         * 思路一：（当数字有负数的情况，此方法有问题）
         * 1.将字符串的数字部分拼接成正确的数字
         * 2.将表达式分成两部分，数字和运算符（只包含+ -），由于+ - 优先级一样，所以可直接忽略括号，直接从左到右运算。
         * 如果包括乘除，括号就不能忽略，也需要用到逆波兰表达式
         */
        List<Integer> numList = new ArrayList<>();
        List<Character> operatorList = new ArrayList<>();
        Character first = s.charAt(0);
        if (isNum(first)) {
            numList.add(first - '0');
        }
        for (int i = 1; i < s.length(); i++) {
            Character nowC = s.charAt(i);
            if(isNum(nowC)){
                // 如果上一个字符是数字，则需要与上一个数字拼成一个新数字
                if (isNum(s.charAt(i - 1))) {
                    int lastNum = numList.get(numList.size() - 1) * 10 + nowC - '0';
                    numList.set(numList.size() - 1, lastNum);
                } else {
                    numList.add(nowC - '0');
                }
            } else if (nowC == '+') {
                operatorList.add('+');
            } else if (nowC == '-') {
                operatorList.add('-');
            }
        }
        int sum = numList.get(0);
        // 数字 与 字符运算
        for (int i = 1; i < numList.size(); i++) {
            if (operatorList.get(i - 1) == '+') {
                sum += numList.get(i);
            } else {
                sum -= numList.get(i);
            }
        }
        return sum;
    }

    /**
     * 判断c是否是数字
     * @param c
     * @return
     */
    private boolean isNum(char c) {
        return '0' <= c && c <= '9';
    }

    public static void main(String[] args) {
        System.out.println(new _224_basicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
