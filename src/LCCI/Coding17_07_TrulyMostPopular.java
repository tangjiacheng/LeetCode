package LCCI;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author: TJC
 * @Date: 2020/7/14 14:33
 * @description:
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，
 * 例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，
 * 另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，
 * 并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 *
 * 在结果列表中，选择字典序最小的名字作为真实名字。
 *
 * 示例：
 *
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
 *       synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * 输出：["John(27)","Chris(36)"]
 * 提示：
 *
 * names.length <= 100000
 */
public class Coding17_07_TrulyMostPopular {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        List<Set<String>> list = new LinkedList<>();
        buildSet(list, synonyms);
        int[] num = new int[list.size()];
        return null;
    }

    private void buildSet(List<Set<String>> list, String[] synonyms) {
        for (String synonym : synonyms) {
            boolean flag = true;
            int begin = 1;
            int index = begin;
            while (synonym.charAt(index) != ',') {
                index++;
            }
            String s1 = synonym.substring(begin, index);
            begin = index + 1;
            index = begin;
            while (synonym.charAt(index) != ')') {
                index++;
            }
            String s2 = synonym.substring(begin, index);
            for (Set<String> set : list) {
                if (set.contains(s1) || set.contains(s2)) {
                    flag = false;
                    set.add(s1);
                    set.add(s2);
                    break;
                }
            }
            if (flag) {
                Set<String> set = new HashSet<>();
                set.add(s1);
                set.add(s2);
                list.add(set);
            }
        }
    }
}
