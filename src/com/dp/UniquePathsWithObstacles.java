package com.dp;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/7/6 14:11
 * @description:
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0] == null) return 0;
        if (obstacleGrid[0].length == 0) return 0;
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] pathNum = new int[cols];
        pathNum[0] = 1 - obstacleGrid[0][0];
        for (int i = 1; i < cols; i++) {
            if (obstacleGrid[0][i] == 1)
                pathNum[i] = 0;
            else
                pathNum[i] = pathNum[i - 1];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                /*if (j == 0) {
                    if (obstacleGrid[i][j] == 1)
                        pathNum[j] = 0;
                } else {
                    if (obstacleGrid[i][j] == 1)
                        pathNum[j] = 0;
                    else
                        pathNum[j] = pathNum[j] + pathNum[j - 1];
                }*/
                if (obstacleGrid[i][j] == 1)
                    pathNum[j] = 0;
                else {
                    if (j > 0)
                        pathNum[j] = pathNum[j] + pathNum[j - 1];
                }
            }
        }
        return pathNum[cols - 1];
    }
}
