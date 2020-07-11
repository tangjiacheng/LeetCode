package com.array;

/**
 * @Author: TJC
 * @Date: 2020/7/8 15:48
 * @description: TODO
 */
public class DivingBoard {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer)
            return new int[]{shorter * k};
        int[] len = new int[k + 1];
        int sum = shorter * k;
        int sub = longer - shorter;
        for (int i = 0; i <= k; i++) {
            len[i] = sum;
            sum += sub;
        }
        return len;
    }
}
