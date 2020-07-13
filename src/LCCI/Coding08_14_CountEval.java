package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/12 21:55
 * @description:
 * 给定一个布尔表达式和一个期望的布尔结果 result，布尔表达式由 0 (false)、1 (true)、& (AND)、 | (OR) 和 ^ (XOR) 符号组成。实现一个函数，算出有几种可使该表达式得出 result 值的括号方法。
 *
 * 示例 1:
 *
 * 输入: s = "1^0|0|1", result = 0
 *
 * 输出: 2
 * 解释: 两种可能的括号方法是
 * 1^(0|(0|1))
 * 1^((0|0)|1)
 * 示例 2:
 *
 * 输入: s = "0&0&0&1^1|0", result = 1
 *
 * 输出: 10
 * 提示：
 *
 * 运算符的数量不超过 19 个
 *
 * 这道题是中等题真的纯属搞笑
 */
public class Coding08_14_CountEval {
    public int countEval(String s, int result) {
        if (s.length() < 3)
            return Integer.parseInt(s) == result ? 1 : 0;
        int len = (s.length() + 1) >> 1;
        char[] chars = s.toCharArray();
        int[][][] dp = new int[len][len][2];
        for (int i = 0; i < len; i++) {
            dp[i][i][0] = s.charAt(2 * i) == '0' ? 1 : 0;
            dp[i][i][1] = s.charAt(2 * i) == '1' ? 1 : 0;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                for (int mid = i; mid < j; mid++) {
                    char eval = chars[mid * 2 + 1];
                    int[] left = dp[i][mid];
                    int[] right = dp[mid + 1][j];
                    switch (eval) {
                        case '|':
                            dp[i][j][0] += left[0] * right[0];
                            dp[i][j][1] += left[1] * right[0] + left[0] * right[1] + left[1] * right[1];
                            break;
                        case '&':
                            dp[i][j][1] += left[1] * right[1];
                            dp[i][j][0] += left[1] * right[0] + left[0] * right[1] + left[0] * right[0];
                            break;
                        case '^':
                            dp[i][j][1] += left[1] * right[0] + left[0] * right[1] ;
                            dp[i][j][0] += left[1] * right[1]+ left[0] * right[0];
                            break;
                        default:
                            break;

                    }

                }
            }
        }
        System.out.println(s);
        printDP(dp);
        return dp[0][len - 1][result];
    }

    private void printDP(int[][][] dp) {
        for (int[][] rows : dp) {
            for (int[] nums : rows) {
                System.out.print(nums[0] + ":" + nums[1] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "0&0&0&1^1|0";
        int result = 1;
        Coding08_14_CountEval eval = new Coding08_14_CountEval();
        System.out.println(eval.countEval(s, result));
    }

}
