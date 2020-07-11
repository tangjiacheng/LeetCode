package LCCI;

import com.utils.BuildTree;
import com.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/11 15:33
 * @description:
 * 设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。
 * 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
 *     3
 *    / \
 *   5   1
 *  / \ / \
 * 6  2 0  8
 *   / \
 *  7   4
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 */
public class Coding04_08_LowestCommonAncestor {

    private final LinkedList<TreeNode> stack = new LinkedList<>();
    private final List<List<TreeNode>> memory = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        findPath(root, p, q);
//        int index = 0;
//        while (index < memory.get(0).size()
//                && index < memory.get(1).size()
//                && memory.get(0).get(index) == memory.get(1).get(index))
//            index++;
//        return memory.get(0).get(index - 1);
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    public void findPath(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return;
        stack.addLast(root);
        if (root == p || root == q)
            memory.add(new LinkedList<>(stack));
        if (memory.size() < 2)
            findPath(root.left, p, q);
        if (memory.size() < 2)
            findPath(root.right, p, q);
        stack.removeLast();
    }

    public static void main(String[] args) {
        String s = "[3,5,1,6,2,0,8,null,null,7,4]";
        TreeNode root = new BuildTree().build(s);
        TreeNode p = root.left;
    }
}
