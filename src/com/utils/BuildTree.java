package com.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/11 15:26
 * @description: TODO
 */
public class BuildTree {

    // Decodes your encoded data to tree.
    public TreeNode build(String data) {
        if (data == null || data.length() < 3)
            return null;
        List<Integer> list = loadNums(data);
        return bfs(list);
    }

    private int index = 0;

    private TreeNode bfs(List<Integer> list) {
        if (index >= list.size())
            return null;
        LinkedList<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(list.get(index++));
        deque.addLast(root);
        while (!deque.isEmpty() && index < list.size()) {
            TreeNode node = deque.removeFirst();
            if (index < list.size()) {
                Integer left = list.get(index);
                if (left != null) {
                    TreeNode leftSon = new TreeNode(left);
                    node.left = leftSon;
                    deque.addLast(leftSon);
                }
            }
            index++;
            if (index < list.size()) {
                Integer right = list.get(index);
                if (right != null) {
                    TreeNode rightSon = new TreeNode(right);
                    node.right = rightSon;
                    deque.addLast(rightSon);
                }
            }
            index++;
        }
        return root;
    }

    private List<Integer> loadNums(String data) {
        List<Integer> list = new ArrayList<>();
        int index = 1;
        while (index < data.length()) {
            int j = index;
            while (data.charAt(j) != ',' && data.charAt(j) != ']') {
                j++;
            }
            if (j > index) {
                if ("null".equals(data.substring(index, j))) {
                    list.add(null);
                } else
                    list.add(Integer.parseInt(data.substring(index, j)));
            }
            index = j + 1;
        }
        return list;
    }
}
