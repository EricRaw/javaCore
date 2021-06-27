package com.eric.myVolatile;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author EricRaww
 * @create 2021-06-24
 * @description volatile不能保证线程安全，原因是volatile不能保证原子性
 * 解决的办法：
 * 1.synchronized
 * 2.lock
 * 3.AtomicInteger
 *
 */
public class MyVolatile2 {
//    private static int num=0;
    private static  AtomicInteger num=new AtomicInteger(0);
//    private static ReentrantLock lock=new ReentrantLock();
    public static void add(){
       num.getAndIncrement();
    }
    public static void main(String[] args) {
        //正确的结果为20000
        for (int i = 1; i <=20 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+num);
    }
}
