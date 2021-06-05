package com.eric.myCountDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2021-05-30
 * @description CyclicBarrier 是加法计数器
 * CountDownLatch 是减法计数器
 */
public class MyCyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("7颗龙珠全部收集完成，神龙出来了");
        });
        for (int i = 1; i <= 7 ; i++) {
            final int temp=i;
            new Thread(()->{
                System.out.println("线程"+Thread.currentThread().getName()+"收集了第"+temp+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
