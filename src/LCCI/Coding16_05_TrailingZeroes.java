package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/13 20:45
 * @description:
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 *
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 */
public class Coding16_05_TrailingZeroes {
    public int trailingZeroes(int n) {
        int base = 5;
        int sum = 0;
        while (n >= base) {
            sum += n / base;
            n /= base;
        }
        return sum;
    }

    public static void main(String[] args) {
        Coding16_05_TrailingZeroes zeroes = new Coding16_05_TrailingZeroes();
        int num = zeroes.trailingZeroes(10);
        System.out.println(num);
    }
}
