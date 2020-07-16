package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/14 16:09
 * @description:
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * 提示：
 *
 * words.length <= 100000
 */
public class Coding17_11_FindClosest {
    public int findClosest(String[] words, String word1, String word2) {
        int index1 = Integer.MIN_VALUE;
        int index2 = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                index1 = i;
                minDist = Math.min(minDist, Math.abs(index1 - index2));
            }
            else if (word2.equals(words[i])) {
                index2 = i;
                minDist = Math.min(minDist, Math.abs(index1 - index2));
            }
        }
        return minDist;
    }
}
