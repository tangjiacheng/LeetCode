package com.string;

import com.utils.TrieTree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: TJC
 * @Date: 2020/7/9 13:39
 * @description:
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 *
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * 示例：
 *
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 *
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 */
public class Respace {
    static class TrieNode {
        char ch;
        int freq;
        Map<Character, TrieNode> nodeMap;

        public TrieNode(char ch, int freq, Map<Character, TrieNode> nodeMap) {
            this.ch = ch;
            this.freq = freq;
            this.nodeMap = nodeMap;
        }
    }

    private TrieNode root;
    int[] dp;

    public int respace(String[] dictionary, String sentence) {
        root = root = new TrieNode('\u0000', 0, new HashMap<>());
        buildTree(dictionary);
        int count = 0;
        dp = new int[sentence.length() + 1];
        dp[sentence.length()] = 0;
        for (int i = sentence.length() - 1; i >= 0; i--) {
            int min = sentence.length() - i;
            for (int j = i + 1; j <= sentence.length(); j++) {
                min = Math.min(min, identify(sentence.substring(i, j)) + dp[j]);
            }
            dp[i] = min;
        }
        return dp[0];
    }

    private int miIdentify(String s) {
        int min = s.length();
        for (int i = 0; i < s.length(); i++) {
            min = Math.min(min, identify(s.substring(0, i)) + dp[i]);
        }
        return min;
    }

    private int identify(String s) {
        if (s.length() == 0) return 0;
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            TrieNode child = cur.nodeMap.get(s.charAt(i));
            if (child == null) {
                return s.length();
            } else
                cur = child;
        }
        if (cur.freq == 0)
            return s.length();
        else
            return 0;
    }

    private void buildTree(String[] dictionary) {
        for (String s : dictionary) {
            add(s);
        }
    }

    private void add(String s) {
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            TrieNode child = cur.nodeMap.get(s.charAt(i));
            if (child == null) {
                TrieNode node = new TrieNode(s.charAt(i), 0, new HashMap<>());
                cur.nodeMap.put(s.charAt(i), node);
                cur = node;
            } else {
                cur = child;
            }
        }
        cur.freq++;
    }

    public static void main(String[] args) {
        Respace respace = new Respace();
        String[] dictionary = {"looked","just","like","her","brother"};
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(respace.respace(dictionary, sentence));
    }
}
