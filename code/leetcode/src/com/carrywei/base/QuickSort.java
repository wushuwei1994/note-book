package com.carrywei.base;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] nums) {
        quickSortBy3(nums, 0, nums.length - 1);
    }

    /**
     * 三路快排
     * @param nums
     * @param l
     * @param h
     */
    private void quickSortBy3(int[] nums, int l, int h) {
        if (l < h) {
            /**
             * 思路：将数据分为三份：等于pivot（标定点）一份，小于pivot一份，大于pivot一份。
             * 设小于pivot的临界下标为i,大于pivot临界为j,则[l, i] < pivot，[j, h] > pivot
             * 假设nums[l]为pivot,  先设i为l, j为h+1，表示小于和大于pivot的数没有找到
             */
            int pivot = nums[l];
            int i = l;
            int j = h + 1;
            for (int k = i + 1; k < j; ) {
                if (nums[k] == pivot) {
                    k++;
                }
                else if (nums[k] < pivot) {
                    i++;
                    int temp = nums[i];
                    nums[i] = nums[k];
                    nums[k] = temp;
                    k++;
                }else{
                    j--;
                    int temp = nums[j];
                    nums[j] = nums[k];
                    nums[k] = temp;
                }
            }
            int temp = nums[i];
            nums[i] = pivot;
            nums[l] = temp;

            // 继续将[l, i] 、[j, h]部分快速排序
            quickSortBy3(nums, l, i);
            quickSortBy3(nums, j, h);

        }
    }

    private void quickSort(int[] nums, int l, int h) {
        if (l < h) {
            int i = l;
            int j = h;
            int key = nums[i];
            while (i < j) {
                while (i < j && nums[j] > key) {
                    j--;
                }
                if (i < j) {
                    nums[i] = nums[j];
                    i++;
                }
                while (i < j && nums[i] < key) {
                    i++;
                }
                if (i < j) {
                    nums[j] = nums[i];
                    j--;
                }
            }
            nums[i] = key;
            quickSort(nums, l, i - 1);
            quickSort(nums, i + 1, h);
        }
    }

    public static void main(String[] args) {
        int[] testData = {24, 29, 47, 99, 78, 19, 71, 47};
        new QuickSort().sort(testData);
        System.out.println(Arrays.toString(testData));

    }
}
