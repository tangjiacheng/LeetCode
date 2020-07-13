package LCCI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/12 15:55
 * @description:
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 *
 * TODO: 这道题没看懂, 先放一放
 */
public class Coding08_02_PathWithObstacles {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        LinkedList<List<Integer>> list = new LinkedList<>();
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            list.add(new LinkedList<>());
            return list;
        }
        int col = obstacleGrid[0].length;
        int[] dp = new int[col + 1];
        dp[1] = 1;
        for (int[] ints : obstacleGrid) {
            for (int i = 0; i < col; i++) {
                if (ints[i] == 1)
                    dp[i + 1] = 0;
                else
                    dp[i + 1] = dp[i + 1] + dp[i];
            }
        }
        if (dp[col] == 0) {
            list.add(new LinkedList<>());
            return list;
        }
        return null;
    }
}
