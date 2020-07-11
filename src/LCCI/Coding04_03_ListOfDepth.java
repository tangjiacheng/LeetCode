package LCCI;

import com.utils.ListNode;
import com.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/11 14:29
 * @description:
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 *
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 */
public class Coding04_03_ListOfDepth {
    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null)
            return new ListNode[0];
        List<ListNode> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(tree);
        while (!queue.isEmpty()) {
            ListNode head = new ListNode(0);
            ListNode cur = head;
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.removeFirst();
                cur.next = new ListNode(node.val);
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
                cur = cur.next;
            }
            list.add(head.next);
        }
        ListNode[] listNodes = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            listNodes[i] = list.get(i);
        }
        return listNodes;
    }
}
