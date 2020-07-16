package LCCI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: TJC
 * @Date: 2020/7/14 10:31
 * @description:
 * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
 *
 * 返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 *
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2:
 *
 * 输入: ["A","A"]
 *
 * 输出: []
 * 提示：
 *
 * array.length <= 100000
 */
public class Coding17_05_FindLongestSubarray {
    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int start = 0;
        int end = -1;
        for (int i = 0; i < array.length; i++) {
            char c = array[i].charAt(0);
            if (c > '9' || c < '0') {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                if (i - map.get(count) > (end - start + 1)) {
                    start = map.get(count) + 1;
                    end = i;
                }
            } else {
                map.put(count, i);
            }
        }
        return Arrays.copyOfRange(array, start, end + 1);
    }

    public static void main(String[] args) {
        Coding17_05_FindLongestSubarray subarray = new Coding17_05_FindLongestSubarray();
        String[] array = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        String[] strings = subarray.findLongestSubarray(array);
        System.out.println(Arrays.toString(strings));
    }
}
