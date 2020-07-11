package com.array;

/**
 * @Author: TJC
 * @Date: 2020/6/5 11:59
 * @description:
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {

        int row = matrix.length;
        if (row == 0) {
            return new int[0];
        }
        int column = matrix[0].length;
        if (column == 0) {
            return new int[0];
        }
        int[] res = new int[row * column];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] flags = new boolean[row][column];
        int direction = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < column * row; i++) {
            res[i] = matrix[x][y];
            flags[x][y] = true;
            int nextX = x + directions[direction][0];
            int nextY = y + directions[direction][1];
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= column || flags[nextX][nextY]) {
                direction = (direction + 1) % 4;
            }
            x = x + directions[direction][0];
            y = y + directions[direction][1];
        }
        return res;
    }
}
