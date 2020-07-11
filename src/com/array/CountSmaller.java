package com.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: TJC
 * @Date: 2020/7/11 10:39
 * @description:
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * 示例:
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class CountSmaller {
    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0)
            return new LinkedList<>();
        int length = nums.length;
        LinkedList<Integer> smaller = new LinkedList<>();
        for (int i = length - 1; i >= 0; i--) {
            int count = 0;
            int num = nums[i];
            int index = i + 1;
            while (index < length && num > nums[index]) {
                if (num > nums[index]) {
                    nums[index - 1] = nums[index];
                    count++;
                    index++;
                } else
                    break;
            }
            nums[index - 1] = num;
            smaller.addFirst(count);
        }
        return smaller;
    }
}
