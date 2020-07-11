package com.tree;

import com.utils.TreeNode;

/**
 * @Author: TJC
 * @Date: 2020/6/21 15:13
 * @description:
 * 给定一个非空二叉树，返回其最大路径和。
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 */
public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] res = maxSubPath(root);
        return res[1];
    }

    public int[] maxSubPath(TreeNode root) {
        int leftPath = 0;
        boolean leftFlag = false;
        int rightPath = 0;
        boolean rightFlag = false;
        int max = Integer.MIN_VALUE;
        int path;
        if (root.left != null) {
            leftFlag = true;
            int[] left = maxSubPath(root.left);
            leftPath = left[0];
            max = Math.max(max, left[1]);
        }
        if (root.right != null) {
            rightFlag = true;
            int[] right = maxSubPath(root.right);
            rightPath = right[0];
            max = Math.max(max, right[1]);
        }
        if (leftFlag) {
            if (rightFlag) {
                path = Math.max(Math.max(leftPath, rightPath) + root.val, root.val);
                max = Math.max(max, leftPath + rightPath + root.val);
            } else {
                path = Math.max(root.val, leftPath + root.val);
            }
            max = Math.max(max, leftPath + root.val);
        } else {
            if (rightFlag) {
                path = Math.max(rightPath + root.val, root.val);
            } else
                path = root.val;
            max = Math.max(max, rightPath + root.val);
        }
        max = Math.max(Math.max(max, root.val), root.val + path);
        return new int[]{path, max};
    }

}
