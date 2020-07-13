package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/12 19:43
 * @description:
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 * 示例2:
 *
 *  输入: n = 10
 *  输出：4
 *  解释: 有四种方式可以凑成总金额:
 * 10=10
 * 10=5+5
 * 10=5+1+1+1+1+1
 * 10=1+1+1+1+1+1+1+1+1+1
 * 说明：
 *
 * 注意:
 *
 * 你可以假设：
 *
 * 0 <= n (总金额) <= 1000000
 */
public class Coding08_11_WaysToChange {
    private final int[] coins = {1, 5, 10, 25};

    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - coins[i] >= 0)
                    dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Coding08_11_WaysToChange change = new Coding08_11_WaysToChange();
        System.out.println(change.waysToChange(900750));
    }
}
