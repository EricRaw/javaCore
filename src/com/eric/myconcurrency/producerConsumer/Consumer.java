package com.eric.myconcurrency.producerConsumer;

import java.util.Random;

/**
 * @author EricRaww
 * @create 2020-12-15
 */
public class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String message=drop.take();
            !"DONE".equals(message);
            message=drop.take()){
            System.out.format("message is %s%n",message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
