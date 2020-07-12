package LCCI;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/7/11 20:54
 * @description:
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
 *
 * 示例1:
 *
 *  输入：num = 2（或者0b10）
 *  输出：[4, 1] 或者（[0b100, 0b1]）
 * 示例2:
 *
 *  输入：num = 1
 *  输出：[2, -1]
 * 提示:
 *
 * num的范围在[1, 2147483647]之间；
 * 如果找不到前一个或者后一个满足条件的正数，那么输出 -1。
 */
public class Coding05_04_FindClosedNumbers {
    public int[] findClosedNumbers(int num) {
        int[] res = {-1, -1};
        int ones = countOne(num);
        for (int i = num + 1; i > 0 && i <= 2147483647; i++) {
            if (countOne(i) == ones) {
                res[0] = i;
                break;
            }
        }
        for (int i = num - 1; i >= 1; i--) {
            if (countOne(i) == ones) {
                res[1] = i;
                break;
            }
        }
        return res;
    }
    private int countOne(int num) {
        int count = 0;
        int index = 1;
        for (int i = 0; i < 32; i++) {
            if ((index & num) != 0) {
                count++;
            }
            index <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Coding05_04_FindClosedNumbers numbers = new Coding05_04_FindClosedNumbers();
        int[] res = numbers.findClosedNumbers(1);
        System.out.println(Arrays.toString(res));
    }
}
