package com.eric.myCountDownLatch;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author EricRaww
 * @create 2021-05-31
 * @description 读写锁
 * 独占锁（写锁），一次只能被一个线程占有
 * 共享锁（读锁），一次可以被多个线程占有
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 1; i <=1000 ; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.put(temp+"",temp+"");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <=1000 ; i++) {
            final int temp=i;
            new Thread(()->{
                myCache.get(temp+"");
            },String.valueOf(i)).start();
        }
    }
}
class MyCache{
    private volatile Map<String,Object> map=new HashMap<>();
    private final Lock readLock=new ReentrantReadWriteLock().readLock();
    private final Lock writeLock=new ReentrantReadWriteLock().writeLock();

    public void put(String key,Object value){
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入done");
        } finally {
            writeLock.unlock();
        }
    }
    public void get(String key){
        readLock.lock();
        try {
            String o = (String)map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取"+key+"的值是"+o);
            System.out.println(Thread.currentThread().getName()+"读取done");
        } finally {
            readLock.unlock();
        }
    }
}
