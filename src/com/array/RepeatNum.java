package com.array;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/6/22 9:45
 * @description: TODO
 */
public class RepeatNum {
    public int repeatNum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return -1;
        }
        int i = 0;
        while (i < numbers.length) {
            System.out.println(Arrays.toString(numbers));
            if (numbers[i] != i) {
                int m = numbers[i];
                if (numbers[m] == numbers[i]) {
                    return numbers[i];
                }
                numbers[i] = numbers[i] ^ numbers[m];
                numbers[m] = numbers[i] ^ numbers[m];
                numbers[i] = numbers[i] ^ numbers[m];
            } else
                i++;
        }
        return -1;
    }
}
