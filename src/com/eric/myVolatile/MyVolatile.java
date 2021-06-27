package com.eric.myVolatile;

import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2021-06-23
 * @description 验证volatile的可见性
 * 1.当不加volatile时程序会死循环
 * 2.加了volatile，线程会结束
 */
public class MyVolatile {
    private static  int num=0;
    public static void main(String[] args) {
        new Thread(()->{
            while (num==0){

            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num=1;
        System.out.println(num);
    }
}
