package com.eric.myThreadLocal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author EricRaww
 * @create 2021-05-07
 * @description
 */
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100082; i++) {
          new Thread(()->{
             list.add(Thread.currentThread().getName());
          }).start();
        }
        System.out.println(list.size());
    }
}
