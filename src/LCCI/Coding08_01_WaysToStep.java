package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/12 15:46
 * @description:
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模 1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 * 示例2:
 *
 *  输入：n = 5
 *  输出：13
 * 提示:
 *
 * n范围在[1, 1000000]之间
 */
public class Coding08_01_WaysToStep {
    public int waysToStep(int n) {
        if (n < 1)
            return 0;
        int step1 = 0;
        int step2 = 1;
        int step3 = 1;
        for (int i = 2; i <= n; i++) {
            int temp = ((step1 + step2) % 1000000007 + step3) % 1000000007;
            step1 = step2;
            step2 = step3;
            step3 = temp;
        }

        return step3;
    }

    public static void main(String[] args) {
        Coding08_01_WaysToStep step = new Coding08_01_WaysToStep();
        for (int i = 1000; i < 1050; i++) {
            System.out.println(step.waysToStep(i));
        }
    }
}
