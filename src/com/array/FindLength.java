package com.array;

/**
 * @Author: TJC
 * @Date: 2020/7/8 17:29
 * @description:
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *  
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 */
public class FindLength {
    public int findLength(int[] A, int[] B) {
        if (A == null || A.length ==0 || B == null || B.length == 0)
            return 0;
        int max = 0;
        int lenA = A.length;
        int lenB = B.length;
        int[] dp = new int[lenB + 1];
        for (int i = lenA - 1; i >= 0; i--) {
            int[] temp = new int[lenB + 1];
            for (int j = lenB - 1; j >= 0; j--) {
                if (A[i] != B[j]) {
                    temp[j] = 0;
                } else {
                    if (i == lenA - 1) {
                        temp[j] = 1;
                    } else {
                        temp[j] = dp[j + 1] + 1;
                    }
                    max = Math.max(max, temp[j]);
                }
            }
            dp = temp;
        }
        return max;
    }
}
