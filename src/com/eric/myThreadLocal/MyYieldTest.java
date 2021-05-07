package com.eric.myThreadLocal;

/**
 * @author EricRaww
 * @create 2021-05-05
 * @description 测试礼让线程方法yield()，看cpu执行
 */
public class MyYieldTest {
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}
class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName()+"线程结束");

    }
}
