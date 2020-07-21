package com.carrywei.base;

/**
 * Created by wushuwei on 2020/6/28.
 * 描述：二分搜索
 */
public class BinarySearch {
    /**
     * 返回目标在数组下标位置，-1表示未找到
     * @param nums 有序数组
     * @param target 目标值
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // l,h为上下边界(闭区间)
        int l = 0, h = nums.length - 1;
        int mid;
        while (l <= h) {
            // 正常中间元素位置为 (l + h)/2，为防止数组越界，故写成 l + (h - l) / 2
            mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        // 未找到对应元素
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] nums = {1, 3, 5, 7, 14, 59, 77};
        System.out.println(binarySearch.search(nums, 8));
    }
}
