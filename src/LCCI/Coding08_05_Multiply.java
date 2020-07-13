package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/12 17:06
 * @description:
 * 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
 *
 * 示例1:
 *
 *  输入：A = 1, B = 10
 *  输出：10
 * 示例2:
 *
 *  输入：A = 3, B = 4
 *  输出：12
 * 提示:
 *
 * 保证乘法范围不会溢出
 */
public class Coding08_05_Multiply {
    public int multiply(int A, int B) {
        if (A == 0 || B == 0)
            return 0;
        if ((B & 1) == 0)
            return multiply(A, B >> 1) << 1;
        else
            return A + (multiply(A, B >> 1) << 1);
    }

    public static void main(String[] args) {
        Coding08_05_Multiply multiply = new Coding08_05_Multiply();
        System.out.println(multiply.multiply(1, 4));
    }
}
