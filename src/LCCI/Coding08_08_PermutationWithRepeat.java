package LCCI;

import java.util.*;

/**
 * @Author: TJC
 * @Date: 2020/7/12 19:02
 * @description:
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 *
 * 示例1:
 *
 *  输入：S = "qqe"
 *  输出：["eqq","qeq","qqe"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
public class Coding08_08_PermutationWithRepeat {
    public String[] permutation(String S) {
        List<String> res = new ArrayList<String>();
        int len = S.length();
        if (len == 0) return new String[0];
        boolean[] used = new boolean[len];
        char[] sChar = S.toCharArray();

        StringBuilder path = new StringBuilder(len);

        // 排序是为了后面的剪枝
        Arrays.sort(sChar);

        dfs(res, sChar, len, path, 0, used);
        return res.toArray(new String[0]);
    }

    /**
     * @param res 结果集
     * @param sChar 输入字符数组
     * @param len 字符数组长度
     * @param path 根结点到任意结点的路径
     * @param depth 当前树的深度
     * @param used 使用标记数组
     */
    private void dfs(List<String> res
            , char[] sChar
            , int len
            , StringBuilder path
            , int depth
            , boolean[] used) {
        // 到达叶子结点
        if (depth == len) {
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {

                // 根据已排序字符数组, 剪枝
                if (i > 0 && sChar[i] == sChar[i-1] && !used[i-1]) {
                    continue;
                }

                path.append(sChar[i]);
                used[i] = true; // 标记选择
                dfs(res, sChar, len, path, depth+1, used);
                path.deleteCharAt(depth);
                used[i] = false; // 撤销选择
            }
        }
    }
}
