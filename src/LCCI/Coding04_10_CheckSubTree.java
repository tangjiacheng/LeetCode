package LCCI;

import com.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/7/11 18:39
 * @description:
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 *
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 *
 * 示例1:
 *
 *  输入：t1 = [1, 2, 3], t2 = [2]
 *  输出：true
 * 示例2:
 *
 *  输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 *  输出：false
 * 提示：
 *
 * 树的节点数目范围为[0, 20000]。
 */
public class Coding04_10_CheckSubTree {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true;
        if (t1 == null)
            return false;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addLast(t1);
        while (!stack.isEmpty()) {
            TreeNode node = stack.removeFirst();
            if (node.val == t2.val) {
                if (compare(node, t2))
                    return true;
            }
            if (node.left != null)
                stack.addLast(node.left);
            if (node.right != null)
                stack.addLast(node.right);
        }
        return false;
    }

    private boolean compare(TreeNode t1, TreeNode t2) {
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.addLast(t1);
        stack2.addLast(t2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.removeFirst();
            TreeNode node2 = stack2.removeFirst();
            if (node1.val != node2.val)
                return false;
            if (
                    node1.left == null && node2.left != null ||
                    node1.left != null && node2.left == null ||
                    node1.right == null && node2.right != null ||
                    node1.right != null && node2.right == null)
                return false;
            if (node1.left != null) {
                stack1.addLast(node1.left);
                stack2.addLast(node2.left);
            }
            if (node1.right != null) {
                stack1.addLast(node1.right);
                stack2.addLast(node2.right);
            }
        }
        return stack1.size() == stack2.size();
    }
}
