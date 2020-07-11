package com.string;

/**
 * @Author: TJC
 * @Date: 2020/5/21 0:04
 * @description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;

        StringBuffer sb = new StringBuffer();
        sb.append('#');
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            sb.append('#');
        }
        int len = sb.length();
        int max = 1;
        int start = 0;
        for (int i = 1; i < sb.length() - 1; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i - j) == 0 || (i + j) == (len - 1) || sb.charAt(i + j) != sb.charAt(i - j)) {
                    if (sb.charAt(i + j) != sb.charAt(i - j))
                        j--;
                    if (j > max) {
                        start = (i - j) >> 1;
                        max = j;
                    }
                    break;
                }
            }
        }

        return s.substring(start, start + max);

    }
}
