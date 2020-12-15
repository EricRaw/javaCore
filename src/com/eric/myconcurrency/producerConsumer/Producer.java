package com.eric.myconcurrency.producerConsumer;

import java.util.Random;

/**
 * @author EricRaww
 * @create 2020-12-15
 */
public class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        String [] importantInfo={
         "eric",
         "Hy",
         "Beijing",
         "guangzhou"
        };
        Random random = new Random();
        for (int i = 0; i < importantInfo.length; i++) {
            drop.put(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        drop.put("DONE");
    }
}
