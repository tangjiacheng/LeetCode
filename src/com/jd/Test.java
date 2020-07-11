package com.jd;

import java.util.*;

/**
 * @Author: TJC
 * @Date: 2020/7/1 12:53
 * @description: TODO
 */
public class Test {
    public static void main(String[] args) {
        /*Numbers numbers = new Numbers();
        String s = "AAAAA";
        System.out.println(numbers.press(s));*/
        Queue<Integer> q = new LinkedList<>();

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(0);
        System.out.println(queue.toString());
        queue.offer(10);
        System.out.println(queue.toString());
        queue.offer(1);
        System.out.println(queue.toString());
        queue.offer(7);
        System.out.println(queue.toString());
        queue.offer(2);
        System.out.println(queue.toString());
        queue.offer(8);
        System.out.println(queue.toString());
        queue.offer(3);
        System.out.println(queue.toString());
        queue.offer(9);
        System.out.println(queue.toString());
        queue.offer(4);
        System.out.println(queue.toString());
        queue.offer(6);
        System.out.println(queue.toString());
        queue.offer(11);
        System.out.println(queue.toString());
        queue.offer(5);
        System.out.println(queue.toString());
        queue.poll();
        System.out.println(queue.toString());

    }
}
