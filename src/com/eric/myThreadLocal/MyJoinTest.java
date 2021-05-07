package com.eric.myThreadLocal;

/**
 * @author EricRaww
 * @create 2021-05-05
 * @description 线程中的thread.join()方法即插队，可通过此方法实现线程的顺序执行
 */
public class MyJoinTest implements Runnable{

    public static void main(String[] args) {
        MyJoinTest myJoinTest = new MyJoinTest();
        Thread thread = new Thread(myJoinTest);
        thread.start();

        for (int i = 0; i <1000 ; i++) {
            System.out.println(Thread.currentThread().getName()+ "is "+i);
            if(i==20){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void run() {
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <10000 ; i++) {
            System.out.println("线程vip来了"+i);
        }
    }
}


