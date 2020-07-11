package LCCI;

import java.util.HashMap;

/**
 * @Author: TJC
 * @Date: 2020/7/7 20:58
 * @description:
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class Coding01_02_CheckPermutation {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s1.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (!hash.containsKey(c))
                return false;
            else {
                int num = hash.get(c);
                if (num == 1) {
                    hash.remove(c);
                } else {
                    hash.put(c, num - 1);
                }
            }
        }
        return hash.isEmpty();
    }
}
