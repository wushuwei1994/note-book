package com.carrywei.problems;

/**
 * 343. 整数拆分
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 **/
public class _343_integerBreak {

    private int[] buff;

    public int integerBreak(int n) {
        buff = new int[n+1];
        return integerBreakRecursionWithBuff(n);
        // return integerBreakRecursion(n);
    }

    /**
     * 递归方式获取最大乘积，当数据有点大时，会出现超时
     * @param n
     * @return
     */
    public int integerBreakRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = this.threeMax(max, i*(n-i), i * integerBreakRecursion(n - i));
        }
        return max;
    }

    public int integerBreakRecursionWithBuff(int n) {
        if (n == 1) {
            return 1;
        }
        int max = 0;
        if (buff[n] != 0) {
            return buff[n];
        }
        for (int i = 1; i < n; i++) {
            max = this.threeMax(max, i*(n-i), i * integerBreakRecursionWithBuff(n - i));
        }
        buff[n] = max;
        return max;
    }

    private int threeMax(int num1, int num2, int num3) {
        int max = Math.max(num1, num2);
        return Math.max(max, num3);
    }

    /**
     * 动态规划解决
     * @param n
     * @return
     */
    public int integerBreakWithDp(int n) {
        //  每个数的最大
        int[] maxValue = new int[n + 1];
        maxValue[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                maxValue[i] = threeMax(maxValue[i], j * maxValue[i - j], j * (i - j));
            }
        }
        return maxValue[n];
    }

    public static void main(String[] args) {
//        System.out.println(new _343_integerBreak().integerBreak(50));
        System.out.println(new _343_integerBreak().integerBreakWithDp(10));
    }
}
