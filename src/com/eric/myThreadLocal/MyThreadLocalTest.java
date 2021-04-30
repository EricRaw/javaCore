package com.eric.myThreadLocal;

import java.util.Random;

/**
 * @author EricRaww
 * @create 2021-05-01
 */
public class MyThreadLocalTest {
    /**
     * 随机休息1000到2000毫秒
     */
    public static void randSleep(){
        Random random = new Random();
        int rand = random.nextInt(1000) + 1000;
        try {
            Thread.sleep(rand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyThreadLocal myThreadLocal = new MyThreadLocal();
        Runnable task1 = () ->{
            for (int i = 0; i <5 ; i++) {
                randSleep();
                myThreadLocal.set(i);
                int num = (int)myThreadLocal.get();
                System.out.println("task1 is "+num);
            }
        };
        Runnable task2 = () ->{
            for (int i = 5; i <10 ; i++) {
                randSleep();
                myThreadLocal.set(i);
                int num = (int)myThreadLocal.get();
                System.out.println("task2 is "+num);
            }
        };
        new Thread(task1).start();
        new Thread(task2).start();
    }
}
