package com.carrywei.problems;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _088_mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        while (m > 0 && n > 0) {
//            while (m > 0 && nums1[m - 1] >= nums2[n - 1]) {
//                nums1[--len] = nums1[--m];
//            }
//            while (m > 0 && n > 0 && nums1[m - 1] < nums2[n - 1]) {
//                nums1[--len] = nums2[--n];
//            }
            if (nums1[m - 1] >= nums2[n - 1]) {
                nums1[--len] = nums1[--m];
            } else {
                nums1[--len] = nums2[--n];
            }
        }
        while (n > 0) {
            nums1[--len] = nums2[--n];
        }
    }
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] newNums = new int[m + n];
        int numIndex1 = 0;
        int numIndex2 = 0;
        int i = 0;
        while (numIndex1 < m && numIndex2 < n) {
            while (numIndex1 < m && nums1[numIndex1] <= nums2[numIndex2]) {
                newNums[i++] = nums1[numIndex1++];
            }
            while (numIndex1 < m && numIndex2 < n && nums1[numIndex1] > nums2[numIndex2]) {
                newNums[i++] = nums2[numIndex2++];
            }
        }
        while (numIndex1 < m) {
            newNums[i++] = nums1[numIndex1++];
        }
        while (numIndex2 < n) {
            newNums[i++] = nums2[numIndex2++];
        }
        for (int j = 0; j < newNums.length; j++) {
            nums1[j] = newNums[j];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,8,0,0,0};
        int m = 4;
        int[] nums2 ={2,5,6};
        int n = 3;
        new _088_mergeSortedArray().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
