package com.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: TJC
 * @Date: 2020/6/6 12:29
 * @description:
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 1;
        for (int num : nums) {
            if (set.remove(num)) {
                int count = 1;
                int cur = num;
                while (set.remove(--cur)) {
                    count++;
                }
                cur = num;
                while (set.remove(++cur)) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
