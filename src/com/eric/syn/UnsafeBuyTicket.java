package com.eric.syn;

/**
 * @author EricRaww
 * @create 2021-05-10
 * @description
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket ticket = new BuyTicket();
        new Thread(ticket,"Me").start();
        new Thread(ticket,"You").start();
        new Thread(ticket,"黄牛党").start();
    }
}
class BuyTicket implements Runnable{
    private int ticketNums= 10;
    boolean flag =true;

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (flag){
                buy();
        }
    }
    private synchronized void buy() {
        if(ticketNums <=0){
            flag=false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}
