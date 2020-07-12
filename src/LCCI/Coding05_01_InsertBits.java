package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/11 19:26
 * @description:
 * 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，到第i位结束。
 * 假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 *
 * 示例1:
 *
 *  输入：N = 10000000000, M = 10011, i = 2, j = 6
 *  输出：N = 10001001100
 * 示例2:
 *
 *  输入： N = 0, M = 11111, i = 0, j = 4
 *  输出：N = 11111
 */
public class Coding05_01_InsertBits {
    public int insertBits(int N, int M, int i, int j) {
        int mask = 0;
        for (int k = i; k <= j; k++) {
            mask <<= 1;
            mask |= 1;
        }
        mask = mask << i;
        mask &= N;
//        int mask = N >>> i;
//        mask <<= (31 - j);
//        M <<= i;
        M <<= i;
        return N ^ mask | M;
    }

    public static void main(String[] args) {
        System.out.println(new Coding05_01_InsertBits().insertBits(1143207437, 1017033, 11, 31));
    }
}
