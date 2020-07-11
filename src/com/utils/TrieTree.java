package com.utils;

import java.util.HashMap;

/**
 * @Author: TJC
 * @Date: 2020/7/2 12:59
 * @description: TODO
 */
public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        root = new TrieNode('\u0000', 0, new HashMap<>());
    }

    /**
     * 查询字符串出现的次数，不存在返回0，存在则返回出现的次数
     */
    public int query(String str) {
        if (root == null)
            return 0;
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            TrieNode child = cur.nodeMap.get(str.charAt(i));
            if (child == null)
                return 0;
            else
                cur = child;
        }
        return cur.freqs;
    }

    /**
     * 添加单词
     */
    public void add(String str) {
        if (root == null) return;
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            TrieNode child = cur.nodeMap.get(str.charAt(i));
            if (child == null) {
                TrieNode node = new TrieNode(str.charAt(i), 0, new HashMap<>());
                cur.nodeMap.put(str.charAt(i), node);
                cur = node;
            } else {
                cur = child;
            }
        }
        cur.freqs++;
    }

    /**
     * 判断字符传是否存在
     */
    public boolean exist(String str) {
        if (root == null)
            return false;
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++) {
            TrieNode child = cur.nodeMap.get(str.charAt(i));
            if (child == null)
                return false;
            else {
                cur = child;
            }
        }
        return true;
    }

    /**
     * 删除字符串，考虑三种情况
     * 1. 如果字符串不存在，则直接返回
     * 2. 如果存在且后面还有字符，则将当前字符串对应的 freqs 设置为0
     * 3. 如果存在且后面没有字符，则直接将该节点删除
     */
    public void remove(String str) {
        if (root == null)
            return;
        TrieNode cur = root;
        TrieNode preNode = root;
        char delCh = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            TrieNode child = cur.nodeMap.get(str.charAt(i));
            if (child.nodeMap == null) {
                return;
            } else if (i < str.length() - 1 && (child.nodeMap.get(str.charAt(i + 1)) != null) && child.nodeMap.size() > 0) {
                preNode = child;
                delCh = str.charAt(i + 1);
            }
            cur = child;
        }
        if (cur.nodeMap.size() > 0)
            cur.freqs = 0;
        else {
            preNode.nodeMap.remove(delCh);
        }
    }
}
