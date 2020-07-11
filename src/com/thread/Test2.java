package com.thread;

import com.string.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: TJC
 * @Date: 2020/7/6 17:58
 * @description: TODO
 */
public class Test2 {
    private volatile static Test2 test2 = null;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final VolatileTest f = new VolatileTest();


        for (int i = 0; i < 100; i++) {
            FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    for (int j = 0; j < 100; j++) {
                        f.decr();
                    }
                    System.out.println(Thread.currentThread().getName());
                    return f.getFlag();
                }
            });
            new Thread(futureTask).start();
//            System.out.println(futureTask.get());
        }
        try {
            Thread.sleep(5000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(f.getFlag());

        /*Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        try {
            String s = futureTask.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
    }
    public static Test2 getInstance() {
        if (test2 == null) {
            synchronized (Test2.class) {
                if (test2 == null) {
                    test2 = new Test2();
                }
            }
        }
        return test2;
    }


}
