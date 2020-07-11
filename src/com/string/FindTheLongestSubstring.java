package com.string;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: TJC
 * @Date: 2020/5/20 22:58
 * @description: 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，
 *               在子字符串中都恰好出现了偶数次。
 */
public class FindTheLongestSubstring {

    /**
     * @description: 前缀和的思想, 利用二进制取异或, 将元音为奇数的二进制结果第一次出现的位置保存在数组中, 参考leetCode
     *               官解
     */
    public int findTheLongestSubstring(String s) {

        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}
