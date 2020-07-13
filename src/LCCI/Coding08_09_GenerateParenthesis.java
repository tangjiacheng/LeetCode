package LCCI;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/12 19:21
 * @description:
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class Coding08_09_GenerateParenthesis {
    private final List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb);
        return list;
    }

    private void dfs(int n, int curLeft, int curRight, StringBuilder sb) {
        if (curLeft == n && curRight == n) {
            list.add(sb.toString());
            return;
        }
        if (curLeft < n) {
            sb.append('(');
            dfs(n, curLeft + 1, curRight, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (curRight < curLeft) {
            sb.append(')');
            dfs(n, curLeft, curRight + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Coding08_09_GenerateParenthesis parenthesis = new Coding08_09_GenerateParenthesis();
        System.out.println(parenthesis.generateParenthesis(3));
    }
}
