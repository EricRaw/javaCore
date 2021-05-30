package com.eric.mylock;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author EricRaww
 * @create 2021-05-29
 * @description ConcurrentModificationException
 * 1.Vector
 * 2.Collections.synchronizedList(list1)
 * 3. new CopyOnWriteArrayList<>();¡
 */
public class MyListDemo {
    public static void main(String[] args) {
//        List<String> list1 = new ArrayList<>();
//        List<String> list = Collections.synchronizedList(list1);
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 10 ; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}
