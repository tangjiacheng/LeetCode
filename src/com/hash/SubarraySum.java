package com.hash;

import java.util.HashMap;

/*给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
    示例 1 :
        输入:nums = [1,1,1], k = 2
        输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
    说明 :
        数组的长度为 [1, 20,000]。
        数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]*/
public class SubarraySum {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1};
        System.out.println(subarraySum(nums, 3));
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0, pre = 0;
        hm.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (hm.containsKey(pre - k)) {
                count += hm.get(pre - k);
            }
            hm.put(pre, hm.getOrDefault(pre, 1));
        }
        return count;
    }
}
