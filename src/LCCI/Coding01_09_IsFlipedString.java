package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/9 17:28
 * @description:
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 * 示例2:
 *
 *  输入：s1 = "aa", s2 = "aba"
 *  输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 */
public class Coding01_09_IsFlipedString {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        for (int i = 0; i < s1.length(); i++) {
            String str = s1.substring(i) + s1.substring(0, i);
            if (str.equals(s2))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = new String("123");
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}
