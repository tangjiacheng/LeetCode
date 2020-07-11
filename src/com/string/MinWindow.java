package com.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: TJC
 * @Date: 2020/5/23 22:33
 * @description:
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class MinWindow {
    HashMap<Character, Integer> ori = new HashMap<>();
    HashMap<Character, Integer> cur = new HashMap<>();

    public String minWindow(String s, String t) {


        for (char ch : t.toCharArray()) {
            ori.put(ch, ori.getOrDefault(ch, 0) + 1);
        }
        int len = s.length() + 1;
        int left = 0;
        int ansL = -1;
        int right = 0;
        int ansR = -1;
        while (right < s.length()) {
            if (ori.containsKey(s.charAt(right))) {
                cur.put(s.charAt(right), cur.getOrDefault(s.charAt(right), 0) + 1);
                while (check() && left <= right) {
                    if (right - left + 1 < len) {
                        len = right - left + 1;
                        ansL = left;
                        ansR = right + 1;
                    }
                    if (ori.containsKey(s.charAt(left))) {
                        cur.put(s.charAt(left), cur.get(s.charAt(left)) - 1);
                    }
                    left++;
                }
            }
            right++;
        }


        return (ansL == -1) ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        for (char ch : ori.keySet()) {
            if (cur.getOrDefault(ch, 0) < ori.get(ch))
                return false;
        }
        return true;
    }
}
