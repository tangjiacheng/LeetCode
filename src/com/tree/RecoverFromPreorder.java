package com.tree;

import com.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: TJC
 * @Date: 2020/6/18 13:26
 * @description: TODO
 */
public class RecoverFromPreorder {



    public TreeNode recoverFromPreorder(String S) {
        if (S == null || S.length() == 0) return null;
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> deque_degree = new ArrayDeque<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < S.length() && S.charAt(index) != '-') {
            sb.append(S.charAt(index++));
        }
        TreeNode root = new TreeNode(Integer.parseInt(sb.toString()));
        TreeNode next = null;
        deque.addLast(root);
        deque_degree.addLast(0);
        while (index < S.length()) {
            int d = 0;
            while (S.charAt(index) == '-') {
                d++;
                index++;
            }
            sb = new StringBuilder();
            while (index < S.length() && S.charAt(index) != '-') {
                sb.append(S.charAt(index++));
            }
            next = new TreeNode(Integer.parseInt(sb.toString()));
            while (deque_degree.getLast() >= d) {
                deque.removeLast();
                deque_degree.removeLast();
            }
            if (deque.getLast().left == null) {
                deque.getLast().left = next;
            } else {
                deque.getLast().right = next;
            }
            deque.addLast(next);
            deque_degree.addLast(d);
        }
        return root;
    }

    /*public void construct(int degree, int current_degree, int index, TreeNode root) {
        if (degree == current_degree) {
            StringBuilder sb = new StringBuilder();
            while (index < s.length() && s.charAt(index) != '-') {
                sb.append(s.charAt(index++));
            }
            TreeNode next = new TreeNode(Integer.parseInt(sb.toString()));
            deque.push(next);
            int d = 0;
            while (s.charAt(index) == '-') {
                d++;
                index++;
            }
            if (root.left == null) {
                root.left = next;
            } else {
                root.right = next;
            }
            construct(degree + 1, d, index, next);
        } else {
            construct(degree - 1, d, index, );
        }
    }*/
}
