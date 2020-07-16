package LCCI;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/7/16 22:06
 * @description:
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * 示例：
 *
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class Coding17_14_SmallestK {
    public int[] smallestK(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int index = partition(arr, left, right);
            if (index == k)
                return Arrays.copyOfRange(arr, 0, k);
            else if (index < k) {
                left = index + 1;
            } else
                right = index - 1;
        }
        return new int[0];
    }

    private int partition(int[] arr, int begin, int end) {
        if (end <= begin)
            return begin;
        int pivot = arr[begin];
        int index = begin + 1;
        for (int i = index; i <= end; i++) {
            if (arr[i] < pivot)
                swap(arr, i, index++);
        }
        swap(arr, begin, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }
}
