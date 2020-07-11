package com.dp;

public class MaxProduct {

    public static void main(String[] args) {


    }

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxi = nums[0];
        int mini = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int max_tmp = maxi * nums[i];
            int min_tmp = mini * nums[i];
            maxi = Math.max(max_tmp, Math.max(min_tmp, nums[i]));
            mini = Math.min(min_tmp, Math.min(max_tmp, nums[i]));
            max = Math.max(max, maxi);
        }
        return max;
    }
}
