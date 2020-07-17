package LCCI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: TJC
 * @Date: 2020/7/17 21:05
 * @description:
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 *
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * 示例 2:
 *
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * 提示：
 *
 * big.length <= 100000
 * 1 <= small.length <= 100000
 */
public class Coding17_18_ShortestSeq {
    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : small) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int left = 0;
        while (left < big.length && !map.containsKey(big[left]))
            left++;
        int right = left - 1;
        int minLeft = 0;
        int minRight = Integer.MAX_VALUE;
        while (left < big.length && right < big.length) {
            boolean check = check(map);
            if (check) {
                if ((minRight - minLeft) > (right - left)) {
                    minRight = right;
                    minLeft = left;
                }
                map.put(big[left], map.get(big[left++]) + 1);
                while (left < right && !map.containsKey(big[left])) {
                    left++;
                }
            } else {
                right++;
                while (right < big.length && !map.containsKey(big[right])) {
                    right++;
                }
                if (right == big.length)
                    break;
                else {
                    map.put(big[right], map.get(big[right]) - 1);
                }
            }
        }
        if (minRight == Integer.MAX_VALUE)
            return new int[0];
        else
            return new int[] {minLeft, minRight};
    }

    private boolean check(Map<Integer, Integer> map) {
        for (Integer value : map.values()) {
            if (value > 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] big = {1,2,3};
        int[] small = {4};
        Coding17_18_ShortestSeq seq = new Coding17_18_ShortestSeq();
        int[] ints = seq.shortestSeq(big, small);
        System.out.println(Arrays.toString(ints));
    }
}
