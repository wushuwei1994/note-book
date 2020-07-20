package com.carrywei.problems;

import java.util.Arrays;

/**
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 示例:
 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:
 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/move-zeroes
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _283_moveZeroes {
    /**
     * 解法1：借助额外的数组，将所有非0元素放置额外的数组，然后再将非0元素放回原来数组，并把剩余元素填充为0
     * @param nums
     */
    public void moveZeroes_1(int[] nums) {
        int notZeroesCount = 0; // 非0元素个数
        int[] notZeroesNums = new int[nums.length];

//        for (int num : nums) {
//            if (num != 0) {
//                notZeroesNums[notZeroesCount++] = num;
//            }
//        }
//        for (int i = 0; i < notZeroesCount; i++) {
//            nums[i] = notZeroesNums[i];
//        }
//        for (int i = notZeroesCount; i < nums.length; i++) {
//            nums[i] = 0;
//        }

        // 优化代码，将0元素，也放置额外数组末尾，放回原来数组可统一操作
        int zeroesIndex = nums.length - 1;
        for (int num : nums) {
            if (num != 0) {
                notZeroesNums[notZeroesCount++] = num;
            } else {
                notZeroesNums[zeroesIndex--] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = notZeroesNums[i];
        }

    }

    /**
     * 解法2：单次遍历，将非0元素往前塞，所有非0元素往前塞完之后，再填充0
     * @param nums
     */
    public void moveZeroes_2(int[] nums) {
        int notZeroesCount = 0; // 非0元素个数
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[notZeroesCount++] = nums[i];
//            }
//        }
//        for (int i = notZeroesCount; i < nums.length; i++) {
//            nums[i] = 0;
//        }

        // 优化方案：将0与非0元素交换
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[notZeroesCount];
                nums[notZeroesCount++] = nums[i];
                nums[i] = temp;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 0, 3, 12, 0};
        _283_moveZeroes obj = new _283_moveZeroes();

//        obj.moveZeroes_1(nums);
        obj.moveZeroes_2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
