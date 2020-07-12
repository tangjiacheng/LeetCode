package LCCI;

import com.utils.BuildTree;
import com.utils.TreeNode;

/**
 * @Author: TJC
 * @Date: 2020/7/11 18:57
 * @description:
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。
 * 注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 *
 * 节点总数 <= 10000
 */
public class Coding04_12_PathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.val == sum)
            count = 1;
        return count + pathSumSelect(root.left, sum - root.val) +
                pathSumSelect(root.right, sum - root.val) +
                pathSum(root.left, sum) +
                pathSum(root.right, sum);
    }

    public int pathSumSelect(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.val == sum)
            count = 1;
        return count + pathSumSelect(root.left, sum - root.val) +
                pathSumSelect(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        String s = "[1,2]";
        TreeNode root = new BuildTree().build(s);
        int i = new Coding04_12_PathSum().pathSum(root, 1);
        System.out.println(i);
    }
}
