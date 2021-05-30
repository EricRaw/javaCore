package com.eric.mylock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author EricRaww
 * @create 2021-05-27
 * @description Condition 实现线程的顺序执行
 */
public class MyConditionDemo {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 8; i++) {
                data.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 8; i++) {
                data.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i <8 ; i++) {
                data.printC();
            }
        },"C").start();
    }
}
class Data{
    private Lock lock= new ReentrantLock();
    private Condition conditionA= lock.newCondition();
    private Condition conditionB= lock.newCondition();
    private Condition conditionC= lock.newCondition();

    /**
     * number
     * 1--A
     * 2--B
     * 3--C
     */
    private int number=1;
    public void printA(){
        lock.lock();
        try {
            while (number !=1){
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>AAAAAAAA");
            number=2;
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while (number !=2){
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>BBBBB");
            number=3;
            conditionC.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while (number !=3){
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName()+"=>CCCCCC");
            number=1;
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
