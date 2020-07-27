package com.carrywei.problems;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _215_kthLargestElementInAnArray {
    /**
     * 第k大的元素，则nums[0, k-1] > nums[k] >= nums[k+1, max],目标值的下标为k-1
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int target = k - 1;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index > target) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
    }

    /**
     * 暴力破解
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_low(int[] nums, int k) {

        int[] larges = new int[k];
        int min = 0;
        for (int i = 0; i < k; i++) {
            larges[i] = nums[i];
            if (nums[i] < larges[min]) {
                min = i;
            }
        }
        // 先选中前k大的数，再从前k大的数里选择最小的数
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > larges[min]) {
                larges[min] = nums[i];
                min = 0;
                for (int j = 0; j < larges.length; j++) {
                    if (larges[j] < larges[min]) {
                        min = j;
                    }
                }
            }
        }
        return larges[min];
    }

    /**
     * 将数组nums的从left到right的数据分为两部分，并放回中间数值的下标index，即nums[left, index -1] >= nums[index] > [index + 1, right]
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right]; // 基准数
        int j = left - 1;
        // 遍历数据，保证nums[left + i, j] >= pivot,则 j+1为小于其的数
        for (int i = left; i < right; i++) {
            if (nums[i] >= pivot) {
                swap(nums, ++j, i);
            }
        }
        swap(nums, j + 1, right);
        return j + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] testData = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 9;
        System.out.println(new _215_kthLargestElementInAnArray().findKthLargest(testData, k));
    }

}
