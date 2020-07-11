package com.thread;

/**
 * @Author: TJC
 * @Date: 2020/7/2 14:56
 * @description: TODO
 */
public class DeadLock {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private void method1() throws InterruptedException {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " 获取到lock1, 请求获取lock2...");
            Thread.sleep(1000);
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " 获取到lock2");
            }
        }
    }

    private void method2() throws InterruptedException {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " 获取到lock2, 请求获取lock1...");
            Thread.sleep(1000);
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " 获取到lock1");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.method1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLock.method2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread2").start();
    }
}
