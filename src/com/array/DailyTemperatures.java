package com.array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Author: TJC
 * @Date: 2020/6/11 12:26
 * @description:
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[T.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < T.length; i++) {
            if (deque.isEmpty() || T[deque.peekFirst()] >= T[i]) {
                deque.addFirst(i);
            }
            else if (T[deque.peekFirst()] < T[i]) {
                while (!deque.isEmpty() && T[i] > T[deque.peekFirst()]) {
                    Integer integer = deque.removeFirst();
                    res[integer] = i - integer;
                }
                deque.addFirst(i);
            }
        }

        return res;
    }
}
