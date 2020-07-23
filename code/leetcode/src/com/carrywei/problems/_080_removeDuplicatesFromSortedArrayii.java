package com.carrywei.problems;

import java.util.Arrays;

/**
 * 80. 删除排序数组中的重复项 II
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _080_removeDuplicatesFromSortedArrayii {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1; // 当前符合条件的元素个数
        int flag = 0; // 最近一个重复元素的位置
        for (int i = 1; i < nums.length; i++) {
            if (nums[result - 1] == nums[i]) {
                if (result - flag == 1) {
                    nums[result] = nums[i];
                    result++;
                }
            } else {
                nums[result] = nums[i];
                flag = result;
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testData = {0,0,1,1,1,1,2,3,3};
        System.out.println(new _080_removeDuplicatesFromSortedArrayii().removeDuplicates(testData));
        System.out.println(Arrays.toString(testData));
    }
}
