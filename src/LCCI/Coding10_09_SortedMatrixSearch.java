package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/13 16:08
 * @description:
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class Coding10_09_SortedMatrixSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int x = matrix.length - 1;
        int y = 0;
        int right = matrix[0].length - 1;

        while (x >= 0 && y <= right) {
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] < target)
                y++;
            else if (matrix[x][y] > target) {
                if (y > 0)
                    y--;
                x--;
            }
        }
        return false;
    }
}
