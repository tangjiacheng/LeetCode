package LCCI;

import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/7/13 16:34
 * @description:
 * 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。请实现数据结构和算法来支持这些操作，也就是说：
 *
 * 实现 track(int x) 方法，每读入一个数字都会调用该方法；
 *
 * 实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例:
 *
 * 输入:
 * ["StreamRank", "getRankOfNumber", "track", "getRankOfNumber"]
 * [[], [1], [0], [0]]
 * 输出:
 * [null,0,null,1]
 * 提示：
 *
 * x <= 50000
 * track 和 getRankOfNumber 方法的调用次数均不超过 2000 次
 */
public class Coding10_10_StreamRank {
    private final LinkedList<Integer> list;

    public Coding10_10_StreamRank() {
        list = new LinkedList<>();
    }

    public void track(int x) {
        int index = findIndex(x);
        list.add(index, x);
    }

    public int getRankOfNumber(int x) {
        return findIndex(x);
    }

    private int findIndex(int x) {
        if (list.isEmpty())
            return 0;
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int num = list.get(mid);
            if (num > x)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Coding10_10_StreamRank streamRank = new Coding10_10_StreamRank();
        System.out.println(streamRank.getRankOfNumber(1));
        streamRank.track(0);
        System.out.println(streamRank.getRankOfNumber(0));
    }
}
