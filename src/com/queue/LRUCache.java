package com.queue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/5/25 15:52
 * @description:
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 */
public class LRUCache {
    int capacity;
    int cur = 0;
    LinkedList<Integer> ll = new LinkedList<>();
    HashMap<Integer, Integer> hm = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (hm.containsKey(key)) {
            ll.remove((Integer) key);
            ll.addLast(key);
            return hm.get(key);
        }
        else return -1;

    }

    public void put(int key, int value) {
        if (hm.containsKey(key)) {
            ll.remove((Integer) key);
        }
        else {
            if (cur == capacity) {
                Integer i = ll.removeFirst();
                hm.remove(i);
            }
            else {
                cur++;
            }
        }
        ll.addLast(key);
        hm.put(key, value);
    }
}
