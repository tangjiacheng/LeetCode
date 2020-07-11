package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: TJC
 * @Date: 2020/7/6 16:59
 * @description: TODO
 */
public class VolatileTest {
    private int flag = 10000;
    final Object mutex = new Object();

    void decr() {
        flag--;
    }

    public int getFlag() {
        return flag;
    }
}


