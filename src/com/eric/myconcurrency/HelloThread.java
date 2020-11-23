package com.eric.myconcurrency;

/**
 * @author EricRaww
 * @create 2020-11-11
 */
public class HelloThread extends Thread {
    @Override
    public void run() {
        String [] names={"James","Eric","HY","Java"};
        for (int i = 0; i < names.length; i++) {
//            try {
//////                Thread.sleep(2000);
//////            } catch (InterruptedException e) {
//////                e.printStackTrace();
//////            }
            System.out.println(Thread.currentThread().getName()+" "+names[i]);
        }
    }
}
