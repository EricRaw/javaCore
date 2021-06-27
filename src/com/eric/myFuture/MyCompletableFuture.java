package com.eric.myFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2021-06-22
 * @description
 */
public class MyCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 没有返回值的异步回调
         */
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+" is runAsync()");
//        });
//        System.out.println(Thread.currentThread().getName()+" is running");
//        completableFuture.get();
        CompletableFuture<String> completableFutureString=CompletableFuture.supplyAsync(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            int i=10/0;
            return "Hello,this is for return";
        });
        System.out.println(Thread.currentThread().getName()+" is running");
        completableFutureString.whenComplete((t,u)->{
            System.out.println("t is "+t);//t是正常的返回结果
            System.out.println("u is "+u);
        }).exceptionally((e)->{
            e.printStackTrace();
            System.out.println(e.getMessage());
            return "error";
        }).get();
    }
}
