package LCCI;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: TJC
 * @Date: 2020/7/14 14:45
 * @description:
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 *
 * 示例：
 *
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * 提示：
 *
 * height.length == weight.length <= 10000
 */
public class Coding17_08_BestSeqAtIndex {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || height.length == 0)
            return 0;
        int len = height.length;
        int[][] person = new int[len][2];
        for (int i = 0; i < len; i++) {
            person[i][0] = height[i];
            person[i][1] = weight[i];
        }
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[len];
        int res = 0;
        dp[0] = 1;
        for (int[] pair : person) {
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0)
                i = -(i + 1);
            dp[i] = pair[1];
            if (i == res)
                ++res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {8378,8535,8998,3766,648,6184,5506,5648,3907,6773};
        int[] weight = {9644,849,3232,3259,5229,314,5593,9600,6695,4340};
        Coding17_08_BestSeqAtIndex seq = new Coding17_08_BestSeqAtIndex();
        System.out.println(seq.bestSeqAtIndex(height, weight));
    }
}
