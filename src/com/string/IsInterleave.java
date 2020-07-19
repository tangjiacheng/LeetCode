package com.string;

/**
 * @Author: TJC
 * @Date: 2020/7/19 14:10
 * @description:
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 *
 * 示例 1:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出: true
 * 示例 2:
 *
 * 输入: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出: false
 */
public class IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null)
            return s1 == null && s2 == null;
        if (s3.length() != s1.length() + s2.length())
            return false;

        return isInterleave(s1, 0, s2, 0, s3, 0);
    }

    public boolean isInterleave(String s1, int index1, String s2, int index2, String s3, int index3) {
        if (index3 == s3.length()) {
            return index1 == s1.length() && index2 == s2.length();
        } else {
            return index1 < s1.length() && s3.charAt(index3) == s1.charAt(index1) && isInterleave(s1, index1 + 1, s2, index2, s3, index3 + 1) ||
                    index2 < s2.length() && s3.charAt(index3) == s2.charAt(index2) && isInterleave(s1, index1, s2, index2 + 1, s3, index3 + 1);
        }
    }

    public static void main(String[] args) {
        IsInterleave interleave = new IsInterleave();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(interleave.isInterleave(s1, s2, s3));
    }
}
