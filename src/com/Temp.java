package com;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/6/22 19:49
 * @description: TODO
 */
public class Temp {
    public static void main(String[] args) {
        int[] cards = new int[] {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(poker(cards, 6, 2)));
    }

    public static int[] poker(int[] cards, int n, int k) {
        int[] res1 = cards;
        int[] res2 = new int[n];


        for (int i = 0; i < k; i++) {
            int left;
            if ((k & 1) == 0)
                left = (n - 1) >> 1;
            else
                left = n >> 1;
            int right = n - 1;
            boolean flag = (i & 1) == 0;
            for (int j = n - 1; j >= 0; j--) {
                if (j == 0 && (n & 1) == 1 && (i & 1) == 0) {
                    flag = !flag;
                }
                res2[j] = flag ? res1[right--] : res1[left--];
                flag = !flag;
            }
            res1 = res2.clone();
        }
        return res2;
    }
}
