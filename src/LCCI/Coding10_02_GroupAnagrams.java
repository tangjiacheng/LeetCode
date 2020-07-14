package LCCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/13 14:28
 * @description:
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Coding10_02_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len = strs.length;
        int[][] store = new int[len][26];
        int cur = 0;
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            int[] count = countChars(str);
            int index = contains(store, cur, count);
            if (index != -1) {
                res.get(index).add(str);
            } else {
                store[cur++] = count;
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
            }
        }
        return res;
    }

    private int contains(int[][] store, int cur, int[] count) {
        for (int i = 0; i < cur; i++) {
            if (Arrays.equals(store[i], count))
                return i;
        }
        return -1;
    }

    private int[] countChars(String str) {
        int[] count = new int[26];
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }


    public static void main(String[] args) {
        Coding10_02_GroupAnagrams groupAnagrams = new Coding10_02_GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
