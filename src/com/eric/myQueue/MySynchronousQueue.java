package com.eric.myQueue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2021-06-06
 * @description 同步队列，进去一个元素，必须等待取出来之后，才能往里面放一个元素
 */
public class MySynchronousQueue {
    public static void main(String[] args) {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();

        new Thread(()->{

            try {
                System.out.println(Thread.currentThread().getName()+" put eric1");
                synchronousQueue.put("eric1");
                System.out.println(Thread.currentThread().getName()+" put eric2");
                synchronousQueue.put("eric2");
                System.out.println(Thread.currentThread().getName()+" put eric3");
                synchronousQueue.put("eric3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                String s=null;
                s = synchronousQueue.take();
                System.out.println(Thread.currentThread().getName()+" took1 "+s);
                s = synchronousQueue.take();
                System.out.println(Thread.currentThread().getName()+" took2 "+s);
                s = synchronousQueue.take();
                System.out.println(Thread.currentThread().getName()+" took3 "+s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();
    }

}
