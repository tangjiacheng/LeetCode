package LCCI;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: TJC
 * @Date: 2020/7/17 22:05
 * @description:
 * 随机产生数字并传递给一个方法。你能否完成这个方法，在每次产生新值时，寻找当前所有值的中间值（中位数）并保存。
 *
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 *
 * 例如，
 *
 * [2,3,4] 的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 */
public class Coding17_20_MedianFinder {

    private final Queue<Integer> minHeap;
    private final Queue<Integer> maxHeap;
    private boolean isEven;


    /** initialize your data structure here. */
    public Coding17_20_MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((x, y) -> y - x);
        isEven = true;
    }

    public void addNum(int num) {
        if (isEven) {
            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && num > minHeap.peek()) {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            } else
                maxHeap.add(num);
        } else {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else
                minHeap.add(num);
        }
        isEven = !isEven;
    }

    public double findMedian() {
        if (isEven) {
            if (maxHeap.isEmpty())
                return 0;
            else
                return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else {
            return maxHeap.peek();
        }
    }
}
