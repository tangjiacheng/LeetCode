package com.array;

import com.algrothms.Sort;

/**
 * @Author: TJC
 * @Date: 2020/6/24 22:04
 * @description: TODO
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Sort.quickSort(nums, 0, nums.length);
        int res = 0;
        int minSub = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 3; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int tmp = nums[i] + nums[low] + nums[high];
                int sub = (tmp - target) < 0 ? (target - tmp) : (tmp - target);
                if (sub == 0)
                    return target;
                else if (sub < target)
                    low++;
                else high--;
                if (sub < minSub) {
                    minSub = Math.min(minSub, sub);
                    res = tmp;
                }
            }
        }
        return res;
    }
}
