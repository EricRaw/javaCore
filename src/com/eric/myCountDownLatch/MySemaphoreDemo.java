package com.eric.myCountDownLatch;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2021-05-30
 * @description 信号量
 */
public class MySemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 6 ; i++) {
            final int temp=i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println("线程"+Thread.currentThread().getName()+"抢到了第"+temp+"个车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("线程"+Thread.currentThread().getName()+"离开了第"+temp+"个车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
