package LCCI;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/7/13 16:45
 * @description:
 * 在一个整数数组中，“峰”是大于或等于相邻整数的元素，相应地，“谷”是小于或等于相邻整数的元素。
 * 例如，在数组{5, 8, 6, 2, 3, 4, 6}中，{8, 6}是峰， {5, 2}是谷。现在给定一个整数数组，将该数组按峰与谷的交替顺序排序。
 *
 * 示例:
 *
 * 输入: [5, 3, 1, 2, 3]
 * 输出: [5, 1, 3, 2, 3]
 * 提示：
 *
 * nums.length <= 10000
 */
public class Coding10_11_WiggleSort {
    public void wiggleSort(int[] nums) {
        /*Arrays.sort(nums);
        int len = nums.length;
        int[] high = Arrays.copyOfRange(nums, len >> 1, len);
        int[] low = Arrays.copyOfRange(nums, 0, len >> 1);
        int index = 0;
        int cur = 0;
        while (index < low.length) {
            nums[cur++] = high[index];
            nums[cur++] = low[index++];
        }
        if (index < high.length)
            nums[cur] = high[index];*/

        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                if (i > 0 && nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            } else {
                if (nums[i] > nums[i - 1])
                    swap(nums, i, i - 1);
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        nums[x] = nums[x] ^ nums[y];
        nums[y] = nums[x] ^ nums[y];
        nums[x] = nums[x] ^ nums[y];
    }
}
