package LCCI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TJC
 * @Date: 2020/7/12 20:54
 * @description:
 * 堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最高的一堆箱子。箱堆的高度为每个箱子高度的总和。
 *
 * 输入使用数组[wi, di, hi]表示每个箱子。
 *
 * 示例1:
 *
 *  输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
 *  输出：6
 * 示例2:
 *
 *  输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
 *  输出：10
 * 提示:
 *
 * 箱子的数目不大于3000个。
 */
public class Coding08_13_PileBox {
    private int max = 0;

    public int pileBox(int[][] box) {
        int len = box.length;
        Arrays.sort(box, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : a[0] - b[0]);
        /*for (int[] ints : box) {
            System.out.println(Arrays.toString(ints));
        }
        return 0;*/
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            int max = 0, base_width = box[i][0], base_depth = box[i][1], base_height = box[i][2];
            for (int j = i - 1; j >= 0; j--) {
                if (box[j][0] < base_width && box[j][1] < base_depth && box[j][2] < base_height) {
                    max = Math.max(max, dp[j]);
                    break;
                }
            }
            dp[i] = max + base_height;
            res = Math.max(res, dp[i]);
        }
        return res;


        /*List<List<Integer>> boxes = new LinkedList<>();
        LinkedList<List<Integer>> curBox = new LinkedList<>();
        for (int[] b : box) {
            List<Integer> newBox = new ArrayList<>();
            for (int i : b) {
                newBox.add(i);
            }
            boxes.add(newBox);
        }

        permutation(boxes, curBox);
        return max;*/
    }

    private void permutation(List<List<Integer>> boxes, LinkedList<List<Integer>> curBox) {
        if (boxes.isEmpty())
            countHeight(curBox);
        for (int i = 0; i < boxes.size(); i++) {
            List<Integer> remove = boxes.remove(i);
            if (curBox.isEmpty() || check(curBox.getLast(), remove)) {
                curBox.addLast(remove);
                permutation(boxes, curBox);
                curBox.removeLast();
            } else {
                permutation(boxes, curBox);
            }
            boxes.add(i, remove);
        }
    }

    private boolean check(List<Integer> last, List<Integer> remove) {
        for (int i = 0; i < 3; i++) {
            if (last.get(i) >= remove.get(i))
                return false;
        }
        return true;
    }

    private void countHeight(List<List<Integer>> curBox) {
        int sum = 0;
        for (List<Integer> box : curBox) {
            sum += box.get(2);
        }
        max = Math.max(max, sum);
    }

    public static void main(String[] args) {
        int[][] box = {{2,3,4},{3,4,5},{2,6,7},{1,1,1}};
        Coding08_13_PileBox pileBox = new Coding08_13_PileBox();
        int i = pileBox.pileBox(box);
        System.out.println(i);
    }

}
