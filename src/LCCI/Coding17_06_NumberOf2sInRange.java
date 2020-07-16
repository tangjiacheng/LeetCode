package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/14 14:18
 * @description:
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 *
 * 示例:
 *
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 * 提示：
 *
 * n <= 10^9
 */
public class Coding17_06_NumberOf2sInRange {
    public int numberOf2sInRange(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        return countTwo(sb);
    }

    private int countTwo(StringBuilder sb) {
        if (sb == null || sb.length() == 0) return 0;
        int first = sb.charAt(0) - '0';
        sb.deleteCharAt(0);
        if (sb.length() == 0) return first < 2 ? 0 : 1;

        int result = 0;
        if (first > 2) {
            result += PowerBase10(sb.length());
        } else if (first == 2) {
            result += Integer.parseInt(sb.toString()) + 1;
        }
        result += first * sb.length() * PowerBase10(sb.length() - 1);
        result += countTwo(sb);
        return result;
    }

    private int PowerBase10(int length) {
        int res = 1;
        while (length > 0) {
            res *= 10;
            length--;
        }
        return res;
    }
}
