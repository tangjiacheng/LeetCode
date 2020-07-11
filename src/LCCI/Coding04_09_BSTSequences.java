package LCCI;

import com.utils.BuildTree;
import com.utils.TreeNode;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/11 16:00
 * @description:
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉树，输出所有可能生成此树的数组。
 *
 * 示例:
 * 给定如下二叉树
 *
 *         2
 *        / \
 *       1   3
 * 返回:
 *
 * [
 *    [2,1,3],
 *    [2,3,1]
 * ]
 */
public class Coding04_09_BSTSequences {
    LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> BSTSequences(TreeNode root) {
        if (root == null) {
            res.add(new LinkedList<>());
            return res;
        }
        LinkedList<Integer> numList = new LinkedList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();

        numList.addLast(root.val);
        if (root.left != null)
            nodeList.addLast(root.left);
        if (root.right != null)
            nodeList.addLast(root.right);
        SubSequences(numList, nodeList);
        return res;
    }

    public void SubSequences(LinkedList<Integer> numList, LinkedList<TreeNode> nodeList) {
        if (nodeList.isEmpty()) {
            res.add(new LinkedList<>(numList));
            return;
        }
        for (int i = nodeList.size() - 1; i >= 0; i--) {
            TreeNode node = nodeList.remove(i);
            numList.addLast(node.val);
            if (node.left != null)
                nodeList.addLast(node.left);
            if (node.right != null)
                nodeList.addLast(node.right);
            SubSequences(numList, nodeList);
            numList.removeLast();
            nodeList.add(i, node);
            if (node.left != null)
                nodeList.removeLast();
            if (node.right != null)
                nodeList.removeLast();
        }
    }

    public static void main(String[] args) {
        Coding04_09_BSTSequences bstSequences = new Coding04_09_BSTSequences();
        String s = "[6,2,7,null,4,null,8]";
        TreeNode root = new BuildTree().build(s);
        long time = System.currentTimeMillis();
        List<List<Integer>> lists = bstSequences.BSTSequences(root);
        time = System.currentTimeMillis() - time;
        System.out.println(time + " ms");
        System.out.println(lists);
    }
}
