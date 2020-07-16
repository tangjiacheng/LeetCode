package LCCI;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TJC
 * @Date: 2020/7/14 15:53
 * @description:
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 *  
 *
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 */
public class Coding17_10_MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length >> 1)
                return num;
        }
        return -1;*/
        int major = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else {
                if (num == major)
                    count++;
                else
                    count--;
            }
        }
        if (count == 0)
            return -1;
        count = 0;
        for (int num : nums) {
            if (major == num)
                count++;
        }
        return count > (nums.length >> 1) ? major : -1;

    }
}
