package com.carrywei.problems;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 *  
 *
 * 示例：
 *
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *  
 *
 * 进阶：
 *
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _209_minimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        // 双指针，滑动窗口形式
        int result = nums.length + 1;
        if (nums == null || nums.length == 0) {
            return result;
        }
        int i = 0;
        int j = -1;
        int tempSum = 0;
        while (i < nums.length) {
            if (j + 1 < nums.length && tempSum < s) {
                tempSum += nums[++j];
            } else {
                tempSum -= nums[i++];
            }
            if (tempSum >= s) {
                result = Math.min(result, j - i + 1);
            }
        }
        if (result == nums.length + 1) {
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new _209_minimumSizeSubarraySum().minSubArrayLen(s, nums));
    }
}
