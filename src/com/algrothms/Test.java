package com.algrothms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

/**
 * @Author: TJC
 * @Date: 2020/6/22 17:12
 * @description: TODO
 */
public class Test {
    public static void main(String[] args) {
        /*QuickSort quickSort = new QuickSort();
        int[] nums = new int[] {51, 123, 52, 1, 76, 8, 234, 85};
        quickSort.quickSort(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));

        Integer x;*/
/*
        Son son = new Son();
        List<? extends Son> list1 = new ArrayList<>();
        List<? super Father> list2 = new ArrayList<>();
        list2.add(new Father());
        list2.add(new Son());
        Son object = (Son) list2.get(0);*/

        Executors.newSingleThreadExecutor();
        Executors.newFixedThreadPool(5);
        Executors.newScheduledThreadPool(5);
        Executors.newCachedThreadPool();
    }
}

class Father {
    {
        System.out.println("father构造代码块1");
    }
    Father() {
        System.out.println("father构造方法");
    }

    {
        System.out.println("father构造代码块2");
    }

    static {
        System.out.println("father静态代码块");
    }
}

class Son extends Father {
    {
        System.out.println("son构造代码块1");
    }

    Son() {
        System.out.println("son构造方法");
    }

    {
        System.out.println("son构造代码块2");
    }

    static {
        System.out.println("son静态代码块");
    }
}
