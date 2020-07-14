package LCCI;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/7/13 21:06
 * @description:
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * 示例：
 *
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 * 提示：
 *
 * 1 <= a.length, b.length <= 100000
 * -2147483648 <= a[i], b[i] <= 2147483647
 * 正确结果在区间[-2147483648, 2147483647]内
 */
public class Coding16_06_SmallestDifference {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int indexA = a.length - 1;
        int indexB = b.length - 1;
        int min = Integer.MIN_VALUE;
        while (indexA >= 0 && indexB >= 0) {
            if (a[indexA] < b[indexB]) {
                min = Math.max(min, a[indexA] - b[indexB--]);
            } else
                min = Math.max(min, b[indexB] - a[indexA--]);
        }
        while (indexA >= 0) {
            if (a[indexA] < b[0]) {
                min = Math.max(min, a[indexA--] - b[0]);
            } else
                min = Math.max(min, b[0] - a[indexA--]);
        }
        while (indexB >= 0) {
            if (a[0] < b[indexB]) {
                min = Math.max(min, a[0] - b[indexB--]);
            } else
                min = Math.max(min, b[indexB--] - a[0]);
        }
        return min < 0 ? -min : min;
    }

    public static void main(String[] args) {
        int[] a = {-2147483648,1};
        int[] b = {2147483647,0};
        Coding16_06_SmallestDifference difference = new Coding16_06_SmallestDifference();
        System.out.println(difference.smallestDifference(a, b));
    }
}
