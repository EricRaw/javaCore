package com.eric.myPool;

import java.util.concurrent.*;

/**
 * @author EricRaww
 * @create 2021-06-12
 * @description Executors 工具类，3大方法,7大参数，四大拒绝策略
 * 线程池的最大容量=maximumPoolSize+LinkedBlockingQueue.Size()
 * AbortPolicy() 线程满了，会拒绝而且抛出异常
 * CallerRunsPolicy() 线程满了,谁调用的就由谁去执行
 * DiscardPolicy()线程满了,就拒绝
 * DiscardOldestPolicy()线程满了，就尝试和最先运行的线程竞争
 */
public class MyPool {
    public static void main(String[] args) {
        /**
         * 定义线程池大小，调优
         * CPU密集型
         * IO密集型
         */
        System.out.println("my mac's cpu 是"+Runtime.getRuntime().availableProcessors()+"核");


        //单个线程
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);//创建一个固定大小的线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();//可伸缩的
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(
                2,
                3,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        try {
            for (int i = 1; i <= 7; i++) {
                executorService.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" is running");
                });
            }
        } finally {
            executorService.shutdown();
        }
    }
}
