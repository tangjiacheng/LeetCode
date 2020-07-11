package com.algrothms;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: TJC
 * @Date: 2020/6/22 11:04
 * @description: TODO
 */
public class SortTest {
    public static void main(String[] args) {
        int N = 50000;
        int times = 8;
        int range = 1000000;
        // 产生随机数组
        int[][] nums = new int[times][N];
        int[][] unSort = new int[times][N];
        Random r = new Random();
        for (int i = 0; i < times; i++) {
            for (int j = 0; j < N; j++) {
                nums[i][j] = r.nextInt(1000000);
            }
        }

        long time;
        long timeSpend;

        for (int i = 0; i < times; i++) {
            unSort[i] = nums[i].clone();
        }
        System.out.println("------------------排序算法比较----------------------");
        System.out.println("nums.length = " + N);
        System.out.println("range = " + range);
        System.out.println("测试次数 = " + times);
        System.out.println("----------------------------------------------------");
        time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Arrays.sort(unSort[i]);
        }
        timeSpend = System.currentTimeMillis() - time;
        System.out.println("java内置  用时: " + timeSpend + " ms");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < times; i++) {
            unSort[i] = nums[i].clone();
        }
        time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Sort.bubbleSort(unSort[i], 0, N);
        }
        timeSpend = System.currentTimeMillis() - time;
        System.out.println("冒泡排序  用时: " + timeSpend + " ms");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < times; i++) {
            unSort[i] = nums[i].clone();
        }
        time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Sort.selectionSort(unSort[i], 0, N);
        }
        timeSpend = System.currentTimeMillis() - time;
        System.out.println("选择排序  用时: " + timeSpend + " ms");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < times; i++) {
            unSort[i] = nums[i].clone();
        }
        time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Sort.insertionSort(unSort[i], 0, N, 1);
        }
        timeSpend = System.currentTimeMillis() - time;
        System.out.println("插入排序  用时: " + timeSpend + " ms");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < times; i++) {
            unSort[i] = nums[i].clone();
        }
        time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Sort.shellSort(unSort[i], new int[] {100, 50, 20, 10, 5, 1});
        }
        timeSpend = System.currentTimeMillis() - time;
        System.out.println("希尔排序  用时: " + timeSpend + " ms");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < times; i++) {
            unSort[i] = nums[i].clone();
        }
        time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Sort.mergeSort(unSort[i]);
        }
        timeSpend = System.currentTimeMillis() - time;
        System.out.println("归并排序  用时: " + timeSpend + " ms");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < times; i++) {
            unSort[i] = nums[i].clone();
        }
        time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Sort.quickSort(unSort[i], 0, N);
        }
        timeSpend = System.currentTimeMillis() - time;
        System.out.println("快速排序  用时: " + timeSpend + " ms");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < times; i++) {
            unSort[i] = nums[i].clone();
        }
        time = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            Sort.heapSort(unSort[i], N);
        }
        timeSpend = System.currentTimeMillis() - time;
        System.out.println("堆排序  用时: " + timeSpend + " ms");
        System.out.println("----------------------------------------------------");
    }
}
