package com.eric.mythreadpool;

/**
 * @author EricRaww
 * @create 2020-11-23
 */
public class MyThreadTask implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" eric is working");
    }
}
