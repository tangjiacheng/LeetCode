package com.utils;

/**
 * @Author: TJC
 * @Date: 2020/7/9 21:46
 * @description: TODO
 */
public class BuildList {

    public static ListNode build(String s) {
        if (s == null || s.length() < 3)
            return null;
        ListNode root = new ListNode(0);
        ListNode endNode = root;
        int index = 1;
        while (index < s.length()) {
            int end = index + 1;
            while (end < s.length() && s.charAt(end) != ',' && s.charAt(end) != ']') {
                end++;
            }
            ListNode node = new ListNode(Integer.parseInt(s.substring(index, end)));
            endNode.next = node;
            endNode = node;
            index = end + 1;
        }
        return root.next;
    }
}
