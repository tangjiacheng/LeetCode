package com.recall;

/**
 * @Author: TJC
 * @Date: 2020/6/22 16:05
 * @description: TODO
 */
public class MovingCount {
    int count = 0;

    public int movingCount(int threshold, int rows, int cols) {

        boolean[][] visited = new boolean[rows][cols];
        if (move(threshold, rows, cols, 0, 0, visited)) {
            count++;
        }
        for (int i = rows - 1; i >= 0; i--) {
            System.out.print(i + ":\t");
            for (int j = 0; j < cols; j++) {
                if (j < 10) {
                    System.out.print(visited[i][j] ? ".  " : "X  ");
                } else
                    System.out.print(visited[i][j] ? ".  " : "X  ");
            }
            System.out.println();
        }
        System.out.print("\t");
        for (int i = 0; i < cols; i++) {
            if (i < 10) {
                System.out.print(i + "  ");
            } else
                System.out.print(i + " ");
        }
        System.out.println();
        return count;
    }

    private boolean move(int threshold, int rows, int cols, int x, int y, boolean[][] visited) {
        if (visited[x][y])
            return false;
        int sum = 0;
        String str = "" + x + y;
        for (char ch : str.toCharArray()) {
            sum += ch - '0';
        }
        if (sum > threshold) {
            return false;
        }
        visited[x][y] = true;
        if (x + 1 < rows && move(threshold, rows, cols, x + 1, y, visited)) {
            count++;
        }
        if (x - 1 >= 0 && move(threshold, rows, cols, x - 1, y, visited)) {
            count++;
        }
        if (y + 1 < cols && move(threshold, rows, cols, x, y + 1, visited)) {
            count++;
        }
        if (y - 1 >= 0 && move(threshold, rows, cols, x, y - 1, visited)) {
            count++;
        }
        return true;
    }
}
