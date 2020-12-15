package com.eric.myconcurrency.producerConsumer;

/**
 * @author EricRaww
 * @create 2020-12-15
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
