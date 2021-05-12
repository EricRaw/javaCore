package com.eric.mylock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author EricRaww
 * @create 2021-05-11
 * @description
 */
public class MyReentrantLock {
    public static void main(String[] args) {

        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();
        new Thread(buyTicket).start();
    }
}
class BuyTicket implements Runnable{
    private final ReentrantLock reentrantLock=new ReentrantLock();
    int ticketNums=10;

    @Override
    public void run() {
        for (;;){
            reentrantLock.lock();
            try {
                if(ticketNums>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else {
                    break;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }
}
