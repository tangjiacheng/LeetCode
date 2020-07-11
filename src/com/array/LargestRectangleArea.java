package com.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: TJC
 * @Date: 2020/5/30 12:12
 * @description: TODO
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0) return 0;

        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(-1);
        for (int i = 0; i < heights.length; i++) {
            if (stack.size() == 1) {
                stack.addLast(i);
            }
            else {
                while (stack.size() > 1 && heights[stack.getLast()] > heights[i]) {
                    int height = heights[stack.removeLast()];
                    int len = i - stack.getLast() - 1;
                    max = Math.max(max, height * len);
                }
                stack.addLast(i);
            }
        }
        while (stack.size() > 1) {
            int height = heights[stack.removeLast()];
            int len = heights.length - stack.getLast() - 1;
            max = Math.max(max, height * len);
        }
        return max;
    }
}
