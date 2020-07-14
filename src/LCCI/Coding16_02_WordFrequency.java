package LCCI;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TJC
 * @Date: 2020/7/13 17:22
 * @description:
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 *
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 * 示例：
 *
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 * 提示：
 *
 * book[i]中只包含小写字母
 * 1 <= book.length <= 100000
 * 1 <= book[i].length <= 10
 * get函数的调用次数不会超过100000
 */
public class Coding16_02_WordFrequency {

    private final TrieNode root;

    static class TrieNode{
        char ch;
        int freq;
        Map<Character, TrieNode> map;

        public TrieNode(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            map = new HashMap<>();
        }

        public void addWord(String word) {
            if (word == null || word.length() == 0)
                return;
            TrieNode cur = this;
            for (int i = 0; i < word.length(); i++) {
                TrieNode child = cur.map.get(word.charAt(i));
                if (child == null) {
                    child = new TrieNode(word.charAt(i), 0);
                    cur.map.put(word.charAt(i), child);
                }
                cur = child;
            }
            cur.freq++;
        }

        public int getFreq(String word) {
            if (word == null || word.length() == 0)
                return 0;
            TrieNode cur = this;
            for (int i = 0; i < word.length(); i++) {
                TrieNode child = cur.map.get(word.charAt(i));
                if (child == null) {
                    return 0;
                }
                cur = child;
            }
            return cur.freq;
        }

    }

    public Coding16_02_WordFrequency(String[] book) {
        root = new TrieNode('\u0000', 0);
        for (String s : book) {
            root.addWord(s);
        }
    }

    public int get(String word) {
        return root.getFreq(word);
    }
}
