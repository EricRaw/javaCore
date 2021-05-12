package com.eric.myCountDownLatch;

import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author EricRaww
 * @create 2021-04-20
 */
public class Customer implements Runnable {
    private CountDownLatch countDownLatch;
    private String name;

    public Customer(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            Random random = new Random();
            System.out.println(sdf.format(new Date()) + " " + name + "出发去饭店");
            Thread.sleep((long) (random.nextDouble() * 3000) + 1000);
            System.out.println(sdf.format(new Date()) + " " + name + "到了饭店");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }
    }
}
