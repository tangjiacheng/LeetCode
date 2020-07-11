package com.algrothms;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/6/22 10:58
 * @description: 排序方法的总结
 */
public class Sort {

    private Sort() {};

    private static void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    /**
     * 冒泡排序
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    public static void bubbleSort(int[] nums, int start, int end) {
        for (int i = end - 1; i > start; i--) {
            for (int j = start; j < i; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }

    /**
     * 选择排序
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    public static void selectionSort(int[] nums, int start, int end) {
        for (int i = start; i < end - 1; i++) {
            int select = i;
            for (int j = i + 1; j < end; j++) {
                if (nums[j] < nums[select]) {
                    select = j;
                }
            }
            swap(nums, select, i);
        }
    }

    /**
     * 插入排序
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    public static void insertionSort(int[] nums, int start, int end, int increasment) {
        for (int i = start + increasment; i < end; i++) {
            int current = nums[i];
            int index = i - increasment;
            while (index >= start && nums[index] > current) {
                nums[index + increasment] = nums[index];
                index = index - increasment;
            }
            nums[index + increasment] = current;
        }
    }

    /**
     * 希尔排序
     * 时间复杂度: 小于O(n^2)
     * 空间复杂度: O(1)
     */
    public static void shellSort(int[] nums, int[] incr) {
        for (int in : incr) {
            insertionSort(nums, 0, nums.length, in);
        }
    }

    /**
     * 归并排序
     * 时间复杂度: O(n*logn)
     * 空间复杂度: O(n^2)
     */
    public static int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int mid = nums.length >> 1;
        return merge(mergeSort(Arrays.copyOfRange(nums, 0, mid)), mergeSort(Arrays.copyOfRange(nums, mid, nums.length)));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int lIdx = 0;
        int rIdx = 0;
        int idx = 0;
        while (lIdx < left.length && rIdx < right.length) {
            if (left[lIdx] < right[rIdx]) {
                result[idx++] = left[lIdx++];
            } else {
                result[idx++] = right[rIdx++];
            }
        }
        while (lIdx < left.length) {
            result[idx++] = left[lIdx++];
        }
        while (rIdx < right.length) {
            result[idx++] = right[rIdx++];
        }
        return result;
    }

    /**
     * 快速排序
     * 时间复杂度: O(n*logn)
     * 空间复杂度: O(1)
     */
    public static void quickSort(int[] nums, int left, int right) {
        int partitionIndex;
        if (left < right) {
            partitionIndex = partition(nums, left, right);
            quickSort(nums, left, partitionIndex);
            quickSort(nums, partitionIndex + 1, right);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int index = left + 1;
        for (int i = index; i < right; i++) {
            if (nums[i] < nums[left]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, left, index - 1);
        return index - 1;
    }

    /**
     * 堆排序
     * 时间复杂度:
     * 空间复杂度:
     */
    public static void heapSort(int[] nums, int topNums) {
        buildMaxHeap(nums);
        int length = nums.length;
        for (int i = nums.length - 1; i >= nums.length - topNums; i--) {
            swap(nums, 0, i);
            length--;
            heapify(nums, 0, length);
        }
    }

    private static void buildMaxHeap(int[] nums) {
        int length = nums.length;
        for (int i = length >> 1; i >= 0; i--) {
            heapify(nums, i, length);
        }
    }

    private static void heapify(int[] nums, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < length && nums[right] > nums[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest, length);
        }
    }
}
