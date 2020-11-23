package com.eric.myconcurrency.producerConsumer;

/**
 * @author EricRaww
 * @create 2020-11-12
 * Message sent from producer to consumer
 */
public class Drop {
    // Message sent from producer
    // to consumer.
    private String message;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public synchronized String take(){
        while (empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty=true;
        notifyAll();
        return message;
    }
    public synchronized void put(String message){
        while (!empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            empty=false;
            this.message=message;
            notifyAll();
        }
    }
}
