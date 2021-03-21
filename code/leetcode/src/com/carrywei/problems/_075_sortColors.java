package com.carrywei.problems;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _075_sortColors {
    public void sortColors(int[] nums) {
        // 计数排序
//        int red0Count = 0;
//        int white1Count = 0;
//        int blue2Count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                red0Count++;
//            } else if (nums[i] == 1) {
//                white1Count++;
//            } else {
//                 blue2Count++;
//            }
//        }
//        for (int i = 0; i < red0Count; i++) {
//            nums[i] = 0;
//        }
//        for (int i = red0Count; i < red0Count + white1Count; i++) {
//            nums[i] = 1;
//        }
//        for (int i = red0Count + white1Count; i < nums.length; i++) {
//            nums[i] = 2;
//        }
        // 三路快排形式，数组最终会有三部分，[0,zero]为0，[zero+1, two-1]为1，[two,nums.length-1]为2
        int zeroIndex = -1;
        int twoIndex = nums.length;
        for (int i = 0; i < twoIndex; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[--twoIndex];
                nums[twoIndex] = nums[i];
                nums[i] = temp;

            } else {
                assert nums[i] == 0;
                int temp = nums[++zeroIndex];
                nums[zeroIndex] = nums[i];
                nums[i] = temp;
                i++;
            }
        }

    }

    public void test(int[] nums) {
        int i = -1;
        int j = nums.length;
        int k = 0;
        while (k < j) {
            if (nums[k] == 2) {
                nums[k] = nums[j - 1];
                nums[j - 1] = 2;
                j--;
            } else if (nums[k] == 1) {
                k++;
            }else {
                i++;
                nums[k] = nums[i];
                nums[i] = 0;
                k++;
            }
        }
    }

    /**
     * 交换数组下标为i,j的数
     * @param nums
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] testData = {0, 2,0,2,1,1,0, 1};
        new _075_sortColors().test(testData);
        System.out.println(Arrays.toString(testData));
    }
}

