package LCCI;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/7/17 21:53
 * @description:
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 *
 * 以任意顺序返回这两个数字均可。
 *
 * 示例 1:
 *
 * 输入: [1]
 * 输出: [2,3]
 * 示例 2:
 *
 * 输入: [2,3]
 * 输出: [1,4]
 * 提示：
 *
 * nums.length <= 30000
 */
public class Coding17_19_MissingTwoNums {
    public int[] missingTwo(int[] nums) {
        int xor = 0;
        for (int i = 1; i <= nums.length + 2; i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        int index = 1;
        while ((xor & index) == 0) {
            index <<= 1;
        }
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 1; i <= nums.length + 2; i++) {
            if ((i & index) == 0) {
                xor1 ^= i;
            } else
                xor2 ^= i;
        }
        for (int num : nums) {
            if ((num & index) == 0) {
                xor1 ^= num;
            } else
                xor2 ^= num;
        }
        return new int[] {xor1, xor2};
    }

    public static void main(String[] args) {
        int[] nums = {1, 4};
        Coding17_19_MissingTwoNums mn = new Coding17_19_MissingTwoNums();
        int[] ints = mn.missingTwo(nums);
        System.out.println(Arrays.toString(ints));
    }
}
