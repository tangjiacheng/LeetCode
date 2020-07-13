package LCCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/12 20:28
 * @description:
 * 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。
 *
 * 注意：本题相对原题做了扩展
 *
 * 示例:
 *
 *  输入：4
 *  输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 *  解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class Coding08_12_SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums.add(i);
        }
        LinkedList<Integer> curNum = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        permutation(n, nums, curNum, res);
        return res;
    }

    private void permutation(int n, LinkedList<Integer> nums, LinkedList<Integer> curNum, List<List<String>> res) {
        if (nums.isEmpty())
            print(n, res, curNum);
        else {
            for (int i = 0; i < nums.size(); i++) {
                Integer remove = nums.remove(i);
                curNum.addLast(remove);
                if (check(curNum)) {
                    permutation(n, nums, curNum, res);
                }
                curNum.removeLast();
                nums.add(i, remove);
            }
        }

    }

    private boolean check(LinkedList<Integer> curNum) {
        int cur = curNum.size() - 1;
        for (int i = 0; i < cur; i++) {
            if (i - cur == curNum.get(i) - curNum.get(cur) || cur - i == curNum.get(i) - curNum.get(cur))
                return false;
        }
        return true;
    }

    private void print(int n, List<List<String>> res, LinkedList<Integer> curNum) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[curNum.get(i)] = 'Q';
            list.add(String.valueOf(chars));
        }
        res.add(list);
    }

    public static void main(String[] args) {
        Coding08_12_SolveNQueens queens = new Coding08_12_SolveNQueens();
        List<List<String>> lists = queens.solveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
