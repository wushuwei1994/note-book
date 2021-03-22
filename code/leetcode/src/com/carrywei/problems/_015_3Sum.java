package com.carrywei.problems;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _015_3Sum {
    public List<List<Integer>> threeSum1(int[] nums) {
        /**
         * 解题思路
         * 三元组元素可能性:
         * 1.三个0
         * 2.一个正数，两个非正数（一个0和一个负数，两个负数）
         * 3.一个负数，两个正数
         *
         * 步骤：
         * 1.将数组分割为三部分，负数，0，正数
         * 2.根据上面三元组可能性，循环遍历对应的元素（借助查找表，去除已找出元素）
         */
        List<List<Integer>> result = new ArrayList<>();
        // 一次遍历，将数组分割为三部分，负数、0、正数，使得[0, i] -> 负数， [i+1, j-1]0，[j, nums.length - 1]
        int i = -1, j = nums.length;
        for (int k = 0; k < j; ) {
            if (nums[k] < 0) {
                int temp = nums[++i];
                nums[i] = nums[k];
                nums[k++] = temp;
            } else if (nums[k] == 0) {
                k++;
            } else {
                int temp = nums[--j];
                nums[j] = nums[k];
                nums[k] = temp;
            }
        }
        // 三个0
        if (j - i - 1 >= 3)
            result.add(Arrays.asList(new Integer[]{0, 0, 0}));
        // 一个正数，两个非正数（一个0和一个负数，两个负数）
        // 第一个非正数下标(从右往左)
        int noPos;
        // 存在0元素
        if (i + 1 != j) {
            noPos = i + 1;
        } else {
            noPos = i;
        }
        if (noPos > 0) { // 如果等于0，则不存在两个非正数
            Set<Integer> posSet = new HashSet<>(); // 正数set
            for (int k = j; k < nums.length; k++) {
                // 未出现过的正数，查找出对应的三元组
                if (!posSet.contains(nums[k])) {
                    result.addAll(threeSum(nums, 0, noPos, nums[k]));
                    posSet.add(nums[k]);
                }
            }
        }
        // 一个负数，两个正数 1, 2
        if (j < nums.length - 1) {
            Set<Integer> negSet = new HashSet<>(); // 负数
            for (int k = 0; k <= i; k++) {
                if (!negSet.contains(nums[k])) {
                    result.addAll(threeSum(nums, j, nums.length - 1, nums[k]));
                    negSet.add(nums[k]);
                }
            }
        }
        return result;
    }

    /**
     * 查找数组nums从low到high的两个不同元素num1、num2，使得这num1 + num2 + num3 = 0
     *
     * @param nums
     * @param low
     * @param high
     * @param num3
     * @return
     */
    private List<List<Integer>> threeSum(int[] nums, int low, int high, int num3) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> findSet = new HashSet();
        Set<Integer> resultSet = new HashSet<>();
        for (int i = low; i <= high; i++) {
            if (!resultSet.contains(nums[i])) {
                if (findSet.contains(nums[i])) {
                    result.add(Arrays.asList(new Integer[]{0 - num3 - nums[i], nums[i], num3}));
                    resultSet.add(0 - num3 - nums[i]);
                    resultSet.add(nums[i]);
                } else {
                    findSet.add(0 - num3 - nums[i]);
                }
            }
        }
        return result;
    }

    /**
     * 将数组数据快速排序
     * @param nums
     * @param left
     * @param left
     * @return
     */
    private void quickSort(int[] nums, int left, int right) {
        if (right <= left) {
            return ;
        }
        int h = right;
        int pivot = left;
        for (int i = left + 1; i <= h;) {
            if (nums[i] > nums[pivot]) {
                int temp = nums[h];
                nums[h] = nums[i];
                nums[i] = temp;
                h--;
            } else {
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                pivot = i;
                i++;
            }
        }
        // 左边快速排序
        quickSort(nums, left, pivot-1);
        // 右边快速排序
        quickSort(nums, pivot + 1, right);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        // 快速排序
        quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> firstSet = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 如果已遍历过，则不再求和
            if (!firstSet.contains(nums[i])) {
                firstSet.add(nums[i]);
                // 求剩下两个数和等于 0 - nums[i]
                Integer target = 0 - nums[i];
                Set<Integer> secondSet = new HashSet<>();
                Map<Integer, Integer> targetMap = new HashMap<>();
                for (int j = i + 1; j < nums.length; j++) {
                    // 找到满足和为0，且之前未出现过的结果
                    if (targetMap.get(nums[j]) != null && !secondSet.contains(nums[j])) {
                        List<Integer> threeSum = Arrays.asList(nums[i], nums[j], target - nums[j]);
                        result.add(threeSum);
                        secondSet.add(nums[j]);
                        secondSet.add(target - nums[j]);
                    } else {
                        targetMap.put(target - nums[j], j);
                    }
                }
            }
            firstSet.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        List r = new _015_3Sum().threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(r);
    }
}
