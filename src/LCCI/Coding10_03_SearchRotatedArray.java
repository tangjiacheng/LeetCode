package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/13 14:50
 * @description:
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 *  输出: 8（元素5在该数组中的索引）
 * 示例2:
 *
 *  输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 *  输出：-1 （没有找到）
 */
public class Coding10_03_SearchRotatedArray {
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0)
            return -1;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (target == arr[left])
                return left;
            int mid = (left + right) >> 1;
            if (arr[mid] == arr[left] && arr[mid] == arr[right]) {
                return linearSearch(arr, left, right, target);
            } else if (arr[mid] == arr[left]) {
                if (arr[mid] == target)
                    return left;
                else
                    left = mid + 1;
            } else if (arr[mid] == arr[right]) {
                right = mid;
            } else if (arr[mid] < arr[right]) {
                if (target > arr[mid] && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid;
            } else {
                if (target >= arr[left] && target <= arr[mid])
                    right = mid;
                else
                    left = mid + 1;
            }
        }
        return target == arr[left] ? left : -1;
    }

    private int linearSearch(int[] arr, int left, int right, int target) {
        for (int i = left; i <= right; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,5,5,1,2,3,4,5};
        int target = 5;
        Coding10_03_SearchRotatedArray searchRotatedArray = new Coding10_03_SearchRotatedArray();
        System.out.println(searchRotatedArray.search(arr, target));
    }
}
