package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/12 14:53
 * @description:
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 *
 * 示例1:
 *
 *  输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 *  输出：2
 * 示例2:
 *
 *  输入：A = 1，B = 2
 *  输出：2
 * 提示:
 *
 * A，B范围在[-2147483648, 2147483647]之间
 */
public class Coding05_06_ConvertInteger {
    public int convertInteger(int A, int B) {
        int count = 0;
        int index = 1;
        int xor = A ^ B;
        for (int i = 0; i < 32; i++) {
            if ((index & xor) != 0)
                count++;
            index <<= 1;
        }
        return count;
    }
}
