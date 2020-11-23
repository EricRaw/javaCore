package com.eric.mythreadpool;

import java.util.concurrent.*;

/**
 * @author EricRaww
 * @create 2020-11-20
 */
public class MyThreadPoolExecutor {
    public static void main(String[] args) {
        //int corePoolSize,
        //int maximumPoolSize,
        //long keepAliveTime,
        //TimeUnit unit,
        //BlockingQueue<Runnable> workQueue,
        //ThreadFactory threadFactory
        //RejectedExecutionHandler handler
        int corePoolSize=50,maximumPoolSize=80;
        long keepAliveTime=1000;

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 60; i++) {
            threadPoolExecutor.execute(new MyThreadTask());
        }
        threadPoolExecutor.shutdown();


    }
}
