package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/7 21:24
 * @description:
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 */
public class Coding01_04_CanPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        long low = 0;
        long high = 0;
        for (char c : s.toCharArray()) {
            if (c >= 64) {
                long index = 1L << (c - 64);
                if ((high & index) != 0)
                    high ^= index;
                else
                    high |= index;
            } else {
                long index = 1L << c;
                if ((low & index) != 0)
                    low ^= index;
                else
                    low |= index;
            }
        }
        if (low != 0 && high != 0)
            return false;
        if (low == 0 && high == 0)
            return true;
        if (low == 0)
            return (high & (high - 1)) == 0;
        else
            return (low & (low - 1)) == 0;
    }
}
