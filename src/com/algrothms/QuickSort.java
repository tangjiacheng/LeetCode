package com.algrothms;

/**
 * @Author: TJC
 * @Date: 2020/6/22 17:04
 * @description: TODO
 */
public class QuickSort {
    public void quickSort(int[] nums, int left, int right) {
        int partition;
        if (left < right) {
            partition = partition(nums, left, right);
            quickSort(nums, left, partition);
            quickSort(nums, partition + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        if (left < right) {
            int start = left + 1;
            int pivot = nums[left];
            int index = left + 1;
            for (int i = left + 1; i < right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, index++, i);
                }
            }
            swap(nums, index - 1, left);
            return index - 1;
        }
        else
            return left;
    }

    private void swap(int[] nums, int index, int i) {
        int tmp = nums[i];
        nums[i] = nums[index];
        nums[index] = tmp;
    }
}
