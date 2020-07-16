package com.tree;

/**
 * @Author: TJC
 * @Date: 2020/7/16 21:12
 * @description:
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i >> 1; j++) {
                sum += 2 * dp[j] * dp[i - 1 - j];
            }
            if ((i & 1) == 1) {
                sum += dp[i >> 1] * dp[i >> 1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees num = new NumTrees();
        int i = num.numTrees(3);
        System.out.println(i);
    }
}
