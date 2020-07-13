package LCCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/12 18:49
 * @description:
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 * 提示:
 *
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
public class Coding08_07_Permutation {
    private final LinkedList<Character> stack = new LinkedList<>();
    private final StringBuilder sb = new StringBuilder();
    private final List<String> res = new ArrayList<>();

    public String[] permutation(String S) {
        for (char c : S.toCharArray()) {
            stack.addLast(c);
        }
        recursive();
        return res.toArray(new String[0]);
    }

    private void recursive() {
        for (int i = 0; i < stack.size(); i++) {
            char c = stack.remove(i);
            sb.append(c);
            if (stack.isEmpty()) {
                res.add(sb.toString());
            } else {
                recursive();
            }
            sb.deleteCharAt(sb.length() - 1);
            stack.add(i, c);
        }
    }

    public static void main(String[] args) {
        Coding08_07_Permutation permutation = new Coding08_07_Permutation();
        String s = "abc";
        String[] strings = permutation.permutation(s);
        System.out.println(Arrays.toString(strings));
    }
}
