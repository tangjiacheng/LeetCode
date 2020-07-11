package com.divideconquer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*输入整数数组 arr ，找出其中最小的 k 个数。
例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。*/
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) return new int[0];
        Queue<Integer> heap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        
        for (int e : arr) {
            if (heap.isEmpty() || heap.size() < k || heap.peek() > e)
                heap.offer(e);
            if (heap.size() > k)
                heap.poll();
        }
        int[] res = new int[heap.size()];
        int i = 0;
        for (int e : heap) {
            res[i++] = e;
        }
        return res;
    }
}

/*
Java中, 堆可以用PriorityQueue创建, 其中默认为小根堆, 可以通过传入比较器对象 (i1, i2) -> Integer.compare(i2, i1) 转换为
大根堆. 堆中涉及的方法有: peak 获取堆顶元素, poll 取出堆顶元素, offer 根据比较器加入元素
 */
