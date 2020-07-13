package com.array;

import java.util.*;

/**
 * @Author: TJC
 * @Date: 2020/7/13 13:08
 * @description:
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶：
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？  采用双指针
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？    交换nums1与nums2
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？  就这么办(不能用双指针)
 */
public class Intersect_II {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int index = 0;
        for (int value : nums1) {
            if (map.containsKey(value)) {
                nums2[index++] = value;
                int count = map.get(value) - 1;
                if (count == 0)
                    map.remove(value);
                else
                    map.put(value, count);
            }
        }
        return Arrays.copyOfRange(nums2, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Intersect_II intersect = new Intersect_II();
        int[] ints = intersect.intersect(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
