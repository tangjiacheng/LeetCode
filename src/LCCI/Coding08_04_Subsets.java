package LCCI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/12 16:55
 * @description:
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Coding08_04_Subsets {
    private final List<List<Integer>> list = new ArrayList<>();
    private final LinkedList<Integer> subList = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            list.add(subList);
            return list;
        }
        recursive(nums, 0);
        return list;
    }

    public void recursive(int[] nums, int index) {
        if (index == nums.length - 1) {
            list.add(new LinkedList<>(subList));
            subList.addLast(nums[index]);
            list.add(new LinkedList<>(subList));
            subList.removeLast();
        } else {
            subList.addLast(nums[index]);
            recursive(nums, index + 1);
            subList.removeLast();
            recursive(nums, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Coding08_04_Subsets subsets = new Coding08_04_Subsets();
        System.out.println(subsets.subsets(nums));
    }
}
