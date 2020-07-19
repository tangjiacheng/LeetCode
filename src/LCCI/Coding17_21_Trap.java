package LCCI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/7/19 15:05
 * @description:
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 思路: 维护一个递减的栈, 出栈时比较栈底元素与入栈元素中的最小值
 */
public class Coding17_21_Trap {
    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (int h : height) {
            if (stack.isEmpty())
                stack.addLast(h);
            else {
                if (h > stack.getLast()) {
                    int minHeight = Math.min(h, stack.getFirst());
                    int count = 0;
                    while (!stack.isEmpty() && h > stack.getLast()) {
                        sum += minHeight - stack.removeLast();
                        count++;
                    }
                    if (!stack.isEmpty()) {
                        for (int i = 0; i < count; i++) {
                            stack.addLast(minHeight);
                        }
                    }
                }
                stack.addLast(h);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Coding17_21_Trap trap = new Coding17_21_Trap();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int sum = trap.trap(height);
        System.out.println(sum);
    }
}
