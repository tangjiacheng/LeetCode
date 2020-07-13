package LCCI;

import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/12 17:14
 * @description:
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 *
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 *
 * 你需要原地修改栈。
 *
 * 示例1:
 *
 *  输入：A = [2, 1, 0], B = [], C = []
 *  输出：C = [2, 1, 0]
 * 示例2:
 *
 *  输入：A = [1, 0], B = [], C = []
 *  输出：C = [1, 0]
 * 提示:
 *
 * A中盘子的数目不大于14个。
 */
public class Coding08_06_Hanota {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        if (n == 0)
            return;
        hanota(n, A, B, C);
    }

    public void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            Integer remove = A.remove(A.size() - 1);
            C.add(remove);
        } else {
            hanota(n - 1, A, C, B);
            Integer remove = A.remove(A.size() - 1);
            C.add(remove);
            hanota(n - 1, B, A, C);
        }

    }
}
