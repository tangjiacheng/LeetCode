package LCCI;

import com.utils.TreeNode;

/**
 * @Author: TJC
 * @Date: 2020/7/11 15:04
 * @description:
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * 示例 1:
 * 输入: root = [2,1,3], p = 1
 *   2
 *  / \
 * 1   3
 * 输出: 2
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], p = 6
 *       5
 *      / \
 *     3   6
 *    / \
 *   2   4
 *  /
 * 1
 * 输出: null
 */
public class Coding04_06_InOrderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;
        if (root == p)
            return findMin(root.right);
        else if (root.val > p.val) {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        }
        else
            return inorderSuccessor(root.right, p);
    }

    private TreeNode findMin(TreeNode root) {
        if (root == null)
            return null;
        while (root.left != null)
            root = root.left;
        return root;
    }
}
