package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/7 22:03
 * @description:
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *  
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class Coding01_05_OneEditAway {
    public boolean oneEditAway(String first, String second) {
        if (first == null || second == null)
            return true;
        if (first.length() == 0)
            return second.length() < 2;
        if (second.length() == 0)
            return first.length() < 2;


        int left1 = 0;
        int right1 = first.length() - 1;
        int left2 = 0;
        int right2 = second.length() - 1;

        if (right1 - right2 > 1 || right2 - right1 > 1)
            return false;

        while (left1 < first.length() && left2 < second.length() && first.charAt(left1) == second.charAt(left2)) {
            left1++;
            left2++;
        }
        while (right1 >= 0 && right2 >= 0 && first.charAt(right1) == second.charAt(right2)) {
            right1--;
            right2--;
        }
//        int diff = right1 - left1 - right2 + left2;
        return right1 - left1 < 1 && right2 - left2 < 1;
    }

    public static void main(String[] args) {
        Coding01_05_OneEditAway oneEditAway = new Coding01_05_OneEditAway();
        String first = "intention";
        String second = "execution";
        System.out.println(oneEditAway.oneEditAway(first, second));
    }
}
