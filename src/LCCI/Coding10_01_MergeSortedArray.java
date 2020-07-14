package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/13 14:22
 * @description:
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * 说明:
 *
 * A.length == n + m
 */
public class Coding10_01_MergeSortedArray {
    public void merge(int[] A, int m, int[] B, int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        int newIndex = m + n - 1;
        while (indexA >= 0 && indexB >= 0) {
            A[newIndex--] = A[indexA] > B[indexB] ? A[indexA--] : B[indexB--];
        }
        /*while (indexA >= 0)
            A[newIndex--] = A[indexA--];*/
        while (indexB >= 0)
            A[newIndex--] = B[indexB--];
    }
}
