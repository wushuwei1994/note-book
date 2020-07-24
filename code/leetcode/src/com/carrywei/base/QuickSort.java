package com.carrywei.base;

import java.util.Arrays;

public class QuickSort {
    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);

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
