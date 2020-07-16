package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/14 10:15
 * @description:
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 *
 * 注意：本题相对书上原题稍作改动
 *
 * 示例 1：
 *
 * 输入：[3,0,1]
 * 输出：2
 *  
 *
 * 示例 2：
 *
 * 输入：[9,6,4,2,3,5,7,0,1]
 * 输出：8
 */
public class Coding17_04_MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (nums[index] == index) {
                left = index + 1;
            } else  {
                right = index - 1;
            }
        }
        return left;
    }

    private int partition(int[] nums, int left, int right) {
        if (left >= right)
            return left;
        int pivot = nums[left];
        int index = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot)
                swap(nums, i, index++);
        }
        swap(nums, left, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }


}
