package com.eric.myconcurrency;

/**
 * @author EricRaww
 * @create 2020-11-11
 */
public class MyClient {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new HelloThread();
        Thread t2 = new HelloThread();
        Thread t3 = new HelloThread();
        t1.start();
        t1.join();
        t2.start();
        t3.start();
    }
}
