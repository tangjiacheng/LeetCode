package LCCI;

import java.util.ArrayList;

/**
 * @Author: TJC
 * @Date: 2020/7/11 20:23
 * @description:
 * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
 *
 * 示例 1：
 *
 * 输入: num = 1775(110111011112)
 * 输出: 8
 * 示例 2：
 *
 * 输入: num = 7(01112)
 * 输出: 4
 */
public class Coding05_03_ReverseBits {
    public int reverseBits(int num) {
        int x = 1;
        int index = 0;
        int preCount1 = 0;
        int preCount0 = 1;
        int max = 1;
        while (index < 32) {
            int count = 0;
            while (index < 32 && (num & x) != 0) {
                x <<= 1;
                count++;
                index++;
            }
            if (preCount0 == 1) {
                max = Math.max(max, 1 + preCount1 + count);
            } else
                max = Math.max(max, 1 + count);
            preCount1 = count;
            count = 0;
            while (index < 32 && (num & x) == 0) {
                x <<= 1;
                count++;
                index++;
            }
            preCount0 = count;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Coding05_03_ReverseBits().reverseBits(2147482622));
    }
}
