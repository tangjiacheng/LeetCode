package LCCI;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: TJC
 * @Date: 2020/7/8 18:49
 * @description:
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class Coding01_08_SetZeros {
    public void setZeroes(int[][] matrix) {

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        for (Integer i : rowSet) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer j : colSet) {
            for (int i = 0; i < row; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Coding01_08_SetZeros zeros = new Coding01_08_SetZeros();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        zeros.setZeroes(matrix);
    }
}
