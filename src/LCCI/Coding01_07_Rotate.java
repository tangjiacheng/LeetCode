package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/8 18:09
 * @description:
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 */
public class Coding01_07_Rotate {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int index = 0;
        while (2 * index < N) {
            int bound = N - 1 - index;
            for (int i = index; i < bound; i++) {
                swap(matrix, index, i, i, bound);
                swap(matrix, index, i, bound, N - 1 - i);
                swap(matrix, index, i, N - 1 - i, index);
            }
            index++;
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        if (matrix[x1][y1] != matrix[x2][y2]) {
            matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
            matrix[x2][y2] = matrix[x1][y1] ^ matrix[x2][y2];
            matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
        }
    }

    public static void main(String[] args) {
        Coding01_07_Rotate rotate = new Coding01_07_Rotate();
        int[][] matrix = {{5, 1, 9}};
        rotate.rotate(matrix);
    }
}
