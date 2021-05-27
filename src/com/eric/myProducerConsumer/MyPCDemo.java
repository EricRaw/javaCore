package com.eric.myProducerConsumer;

/**
 * @author EricRaww
 * @create 2021-05-13
 * @description
 */
public class MyPCDemo {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        Productor productor = new Productor(container);
        Consumer consumer = new Consumer(container);
        productor.start();
        consumer.start();
    }
}


class Productor extends Thread{
    SynContainer synContainer;
    public Productor(SynContainer synContainer){
        this.synContainer=synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (synContainer) {
                System.out.println("生产了"+i+"只鸡");
            }
            synContainer.push(new Chicken(i));
        }
    }
}
class Consumer extends Thread{
    SynContainer synContainer;
    public Consumer(SynContainer synContainer){
        this.synContainer=synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (synContainer) {
                System.out.println("消费了--》"+synContainer.pop().id+"只鸡");
            }
        }
    }
}
class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}
class SynContainer{
    Chicken [] chickens= new Chicken[10];
    /**
     * 容器计数器
     */
    int count=0;
    /**
     * 生产者放入产品
     */
    public synchronized void push(Chicken chicken){
        //容器已满，等待消费者消费
        if (chickens.length==count){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count]=chicken;
        count++;
        this.notifyAll();
    }
    public synchronized Chicken pop(){
        //不能消费，等待生产者生产
        if(0==count){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Chicken chicken=chickens[count];
        this.notifyAll();
        return chicken;
    }


}