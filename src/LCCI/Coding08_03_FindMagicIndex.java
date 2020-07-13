package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/12 16:18
 * @description:
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个[有序]整数数组，编写一种方法找出魔术索引，
 * 若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 * 示例2:
 *
 *  输入：nums = [1, 1, 1]
 *  输出：1
 * 提示:
 *
 * nums长度在[1, 1000000]之间
 */
public class Coding08_03_FindMagicIndex {
    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        return biSearch(nums, left, right);
    }

    private int biSearch(int[] nums, int left, int right) {
        if (left > right)
            return -1;
        int mid = (left + right) >> 1;
        int min = biSearch(nums, left, mid - 1);
        if (mid == nums[mid]) {
            return min == -1 ? mid : min;
        } else {
            return min == -1 ? biSearch(nums, mid + 1, right) : min;
        }
    }

    public static void main(String[] args) {
        Coding08_03_FindMagicIndex index = new Coding08_03_FindMagicIndex();
        int[] nums = {0,0,2};
        System.out.println(index.findMagicIndex(nums));
    }
}
