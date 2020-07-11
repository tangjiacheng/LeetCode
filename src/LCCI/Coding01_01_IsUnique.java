package LCCI;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/7/7 20:45
 * @description:
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 */
public class Coding01_01_IsUnique {
    public boolean isUnique(String astr) {
        /*int[] hash = new int[256];
        Arrays.fill(hash, 0);
        for (char c : astr.toCharArray()) {
            if (hash[(int) c + 128] != 0)
                return false;
            else
                hash[(int) c + 128] = 1;
        }
        return true;*/

        long low = 0L;
        long high = 0L;
        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long index = 1L << (c - 64);
                if ((high & index) != 0)
                    return false;
                high |= index;
            } else {
                long index = 1L << c;
                if ((low & index) != 0)
                    return false;
                low |= index;
            }
        }
        return true;
    }
}
