package com.set;

import java.util.*;

/**
 * @Author: TJC
 * @Date: 2020/6/8 12:55
 * @description:
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
 *
 * 示例 1：
 * 输入：["a==b","b!=a"]
 * 输出：false
 * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
 *
 * 示例 2：
 * 输出：["b==a","a==b"]
 * 输入：true
 * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
 *
 * 示例 3：
 * 输入：["a==b","b==c","a==c"]
 * 输出：true
 *
 * 示例 4：
 * 输入：["a==b","b!=c","c==a"]
 * 输出：false
 *
 * 示例 5：
 * 输入：["c==c","b==d","x!=z"]
 * 输出：true
 *
 * 提示：
 * 1 <= equations.length <= 500
 * equations[i].length == 4
 * equations[i][0] 和 equations[i][3] 是小写字母
 * equations[i][1] 要么是 '='，要么是 '!'
 * equations[i][2] 是 '='
 */
public class EquationsPossible {
    private List<Set<Character>> list = new LinkedList<>();

    public boolean equationsPossible(String[] equations) {
        Set<Integer> notEqual = new HashSet<>();
        for (int i = 0; i < equations.length; i++) {
            if (equations[i].charAt(1) == '!') {
                notEqual.add(i);
            }
            else if (equations[i].charAt(0) != equations[i].charAt(3)){
                char ch1 = equations[i].charAt(0);
                int idx1 = containsChar(ch1);
                char ch2 = equations[i].charAt(3);
                int idx2 = containsChar(ch2);

                if ((idx1 == -1) & (idx2 == -1)) {
                    Set<Character> s = new HashSet<>();
                    s.add(ch1);
                    s.add(ch2);
                    list.add(s);
                }else if ((idx1 == -1) & (idx2 != -1) | (idx1 != -1) & (idx2 == -1)) {
                    if (idx1 == -1) {
                        list.get(idx2).add(ch1);
                    }else
                        list.get(idx1).add(ch2);
                }else {
                    if (idx1 != idx2)
                        merge(idx1, idx2);
                }
            }
        }
        for (Integer i : notEqual) {
            char ch1 = equations[i].charAt(0);
            char ch2 = equations[i].charAt(3);
            if (ch1 == ch2)
                return false;
            int idx1 = containsChar(ch1);
            int idx2 = containsChar(ch2);
            if (idx1 == idx2 & idx1 != -1)
                return false;
        }
        return true;
    }

    public Integer containsChar(char ch) {
        if (list.isEmpty())
            return -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(ch))
                return i;
        }
        return -1;
    }

    public void merge(int i, int j) {
        if (list.get(i).size() < list.get(j).size()) {
            int tmp = i;
            i = j;
            j = tmp;
        }
        list.get(i).addAll(list.get(j));
        list.remove(j);
    }
}
