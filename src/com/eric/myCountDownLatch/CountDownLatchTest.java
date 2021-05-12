package com.eric.myCountDownLatch;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author EricRaww
 * @create 2021-04-20
 * 简单的CountDownLatch例子
 * CountDownLatchCountDownLatch是JDK提供的一个同步工具，
 * 它可以让一个或多个线程等待，一直等到其他线程中执行完成一组操作。
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ArrayList<Thread> threads = new ArrayList<>(3);
        threads.add(new Thread(new Customer(countDownLatch, "路飞")));
        threads.add(new Thread(new Customer(countDownLatch, "Zero")));
        threads.add(new Thread(new Customer(countDownLatch, "红发")));
        for (Thread t : threads) {
            t.start();
        }
        Thread.sleep(100);
        new Thread(new Waitress(countDownLatch, "Hi,Im waitress")).start();
        for (Thread t : threads) {
            t.join();
        }
    }
}
