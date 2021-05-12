package com.eric.myCountDownLatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2021-04-20
 */
public class Waitress implements Runnable {
    private CountDownLatch countDownLatch;
    private String name;

    public Waitress(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
            System.out.println(sdf.format(new Date()) + " " + name + "等待顾客");
            countDownLatch.await(3, TimeUnit.SECONDS);
            System.out.println(sdf.format(new Date()) + " " + name + "开始上菜");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
