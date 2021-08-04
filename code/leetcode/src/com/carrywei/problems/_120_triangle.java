package com.carrywei.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 *
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 *
 * 输入：triangle = [[-10]]
 * 输出：-10
 *
 *
 * 提示：
 *
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 *
 *
 * 进阶：
 *
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 */
public class _120_triangle {
    private static Integer[][] mininumTotal = new Integer[200][200];

    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0);
    }

    /**
     * 获取顶点为triangle[i][j]三角形的最小路径和
     * @param triangle
     * @param i
     * @param j
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle, int i, int j) {
        // 最后一列
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }
        if (mininumTotal[i][j] != null) {
            return mininumTotal[i][j];
        }
        // 左边的最小路径
        int left = minimumTotal(triangle, i + 1, j);
        int right = minimumTotal(triangle, i + 1, j + 1);
        if (left < right) {
            mininumTotal[i][j] = triangle.get(i).get(j) + left;
        } else {
            mininumTotal[i][j] = triangle.get(i).get(j) + right;
        }
        return mininumTotal[i][j];
    }


    public int minimumTotal1(List<List<Integer>> triangle) {
        // 记录到达每一层元素的最小路径和
        int[] minimumRow = new int[triangle.get(triangle.size() - 1).size()+1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 下一层到达上一层的最小路径
                minimumRow[j] = Math.min(minimumRow[j], minimumRow[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minimumRow[0];
    }

    public static void main(String[] args) {
        int[][] testData = {{2},{3,4},{6,5,7},{4,1,8,3}};
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < testData.length; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < testData[i].length; j++) {
                col.add(testData[i][j]);
            }
            triangle.add(col);
        }
        int result = new _120_triangle().minimumTotal(triangle);
        System.out.println(result);
    }
}
