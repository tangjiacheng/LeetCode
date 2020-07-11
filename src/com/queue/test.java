package com.queue;

/**
 * @Author: TJC
 * @Date: 2020/5/25 16:11
 * @description: TODO
 */
public class test {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));


              // 返回  1
        ;    // 该操作会使得密钥 2 作废
        ;       // 返回 -1 (未找到)
        ;    // 该操作会使得密钥 1 作废
        ;       // 返回 -1 (未找到)
        ;       // 返回  3
        ;       // 返回  4
    }
}
