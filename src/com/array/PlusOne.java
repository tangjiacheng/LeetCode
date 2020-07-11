package com.array;

/**
 * @Author: TJC
 * @Date: 2020/7/7 20:33
 * @description:
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        boolean carry = true;
        while (carry && index >= 0) {
            if (digits[index] == 9) {
                digits[index] = 0;
                carry = true;
                --index;
            } else {
                digits[index--] += 1;
                carry = false;
            }
        }
        if (carry && index == -1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        } else
            return digits;
    }
}
