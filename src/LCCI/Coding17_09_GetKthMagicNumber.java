package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/14 15:44
 * @description:
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 */
public class Coding17_09_GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        if (k < 1)
            return -1;
        int[] num = new int[k];
        num[0] = 1;
        int index3 = 0, index5 = 0, index7 = 0;
        int next3 = 3, next5 = 5, next7 = 7;
        for (int i = 1; i < k; i++) {
            int min = Math.min(next3, Math.min(next5, next7));
            num[i] = min;
            while (next3 <= min)
                next3 = 3 * num[++index3];
            while (next5 <= min)
                next5 = 5 * num[++index5];
            while (next7 <= min)
                next7 = 7 * num[++index7];
        }
        return num[k - 1];
    }
}
