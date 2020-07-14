package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/14 10:10
 * @description:
 * 设计一个函数把两个数字相加。不得使用 + 或者其他算术运算符。
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *  
 *
 * 提示：
 *
 * a, b 均可能是负数或 0
 * 结果不会溢出 32 位整数
 */
public class Coding17_01_AddWithoutPlus {
    public int add(int a, int b) {
        do {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        } while (b != 0);
        return a;
    }
}
