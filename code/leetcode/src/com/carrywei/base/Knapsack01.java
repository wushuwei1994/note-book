package com.carrywei.base;

/**
 * 01背包问题
 */
public class Knapsack01 {
    /**
     * 商品最大价值
     * @param w 每件商品重量
     * @param v 每件商品价值
     * @param C 背包容量
     * @return
     */
    public int bestValue(int[] w, int[] v, int C) {
        return bestValue(w, v, w.length - 1, C);
    }

    /**
     * [0, index]商品里的最大值商品
     * @param w 每件商品重量
     * @param v 每件商品价值
     * @param index 第index商品
     * @param C 背包容量
     * @return
     */
    public int bestValue(int[] w, int[] v, int index, int C) {
        if (index < 0 || C <= 0) {
            return 0;
        }
        // 不拿index商品的最大总价值
        int r1 = bestValue(w, v, index - 1, C);
        // 拿index商品的最大总价值
        if (C >= w[index]) {
            int r2 = bestValue(w, v, index - 1, C - w[index]) + v[index];
            return Math.max(r1, r2);
        } else {
            return r1;
        }
    }


    /**
     * 动态规划求得商品最大价值
     * @param w 每件商品重量
     * @param v 每件商品价值
     * @param C 背包容量
     * @return
     */
    public int bestValueWithDp(int[] w, int[] v, int C) {
        // 记录v.length个商品在C容量大背包时的最大价值
        int[][] result = new int[v.length][C+1];
        // 初始化第一个商品在不同容量背包下的价值
        for (int i = 0; i <= C; i++) {
            result[0][i] = w[0] <= i ? v[0] : 0;
        }
        for (int i = 1; i < w.length; i++) {
            for (int j = 0; j <= C; j++) {
                // 背包状态转义方程：f(i, c) = max{f(i-1, c), f(i-1, c-w[i]) + v1}
                result[i][j] = Math.max(result[i - 1][j], j > w[i] ? v[i] + result[i - 1][j - w[i]] : 0);
            }
        }
        return bestValue(w, v, w.length - 1, C);
    }

    public static void main(String[] args) {
        // 用例1
//        int[] w = {1, 2, 3, 7, 6, 1, 2};
//        int[] v = {6, 10, 12, 6, 1, 3, 7};
//        int C = 10;

        // 用例2
        int[] w = {1, 2, 3};
        int[] v = {6, 10, 12};
        int C = 10;
        System.out.println(new Knapsack01().bestValue(w, v, C));
        System.out.println(new Knapsack01().bestValueWithDp(w ,v, C));
    }
}
