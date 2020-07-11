package LCCI;

import java.util.*;

/**
 * @Author: TJC
 * @Date: 2020/7/11 12:42
 * @description:
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * 示例1:
 *  输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 *  输出：true
 * 示例2:
 *  输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 *  输出 true
 * 提示：
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 *
 * 做法: 邻接表
 */
public class Coding04_01_FindWhetherExistsPath {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Deque<Integer> deque = new LinkedList<>();
        @SuppressWarnings({"unchecked"})
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[n];
        for (int[] edge : graph) {
            if (adj[edge[0]] == null) {
                adj[edge[0]] = new ArrayList<>();
            }
            adj[edge[0]].add(edge[1]);
        }
        boolean[] visited = new boolean[n];
        deque.addLast(start);
        while (!deque.isEmpty()) {
            int cur = deque.removeFirst();
            ArrayList<Integer> list = adj[cur];
            if (list == null || list.size() == 0)
                continue;
            for (int end : list) {
                if (end == target)
                    return true;
                if (visited[end])
                    continue;
                visited[end] = true;
                deque.addLast(end);
            }
        }
        return visited[target];
    }
}
