package LCCI;

import java.util.*;

/**
 * @Author: TJC
 * @Date: 2020/7/16 22:22
 * @description:
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。
 * 若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 *
 * 示例：
 *
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 * 提示：
 *
 * 0 <= len(words) <= 100
 * 1 <= len(words[i]) <= 100
 */
public class Coding17_15_LongestWord {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length());
        String res = "";
        TrieTree root = new TrieTree('\u0000', 0, new HashMap<>());
        for (int i = 0; i < words.length; i++) {
            if (i > 0 && words[i - 1].equals(words[i]))
                continue;
            String s = root.addWord(root, words[i]);
            if (s.length() > res.length())
                res = s;
        }
        return res;
    }

    public static class TrieTree {
        char ch;
        int freq;
        Map<Character, TrieTree> treeMap;

        public TrieTree(char ch, int freq, Map<Character, TrieTree> treeMap) {
            this.ch = ch;
            this.freq = freq;
            this.treeMap = treeMap;
        }

        public String addWord(TrieTree root, String word) {
            TrieTree cur = root;
            boolean flag = false;
            for (int i = 0; i < word.length(); i++) {
                TrieTree child = cur.treeMap.get(word.charAt(i));
                if (child == null) {
                    TrieTree node = new TrieTree(word.charAt(i), 0, new HashMap<>());
                    cur.treeMap.put(word.charAt(i), node);
                    cur = node;
                } else
                    cur = child;
                if (cur.freq != 0 && !flag) {
                    flag = check(root, word, i + 1);
                }
            }
            cur.freq++;
            if (flag)
                return word;
            else return "";
        }

        private boolean check(TrieTree root, String word, int index) {
            if (index >= word.length())
                return true;
            TrieTree cur = root;
            boolean flag = false;
            for (int i = index; i < word.length(); i++) {
                TrieTree child = cur.treeMap.get(word.charAt(i));
                if (child == null) {
                    return false;
                }
                cur = child;
                if (cur.freq != 0) {
                    flag = check(root, word, i + 1);
                }
                if (flag)
                    break;
            }
            return flag;
        }
    }

    public static void main(String[] args) {
        String[] words = {"zoddld","god","o","oi","ozzbxoio","olgo","o","gblzdldxbz","xboolo"};
        Coding17_15_LongestWord longestWord = new Coding17_15_LongestWord();
        String s = longestWord.longestWord(words);
        System.out.println(s);
    }
}
