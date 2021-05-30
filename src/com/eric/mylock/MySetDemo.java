package com.eric.mylock;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author EricRaww
 * @create 2021-05-29
 * @description
 * HashSet是线程不安全的，java.util.ConcurrentModificationException
 *1.Collections.synchronizedSet(new HashSet<>());
 *2.new CopyOnWriteArraySet<>();
 */
public class MySetDemo {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        Set<String> set=Collections.synchronizedSet(new HashSet<>());
        Set<String> set= new CopyOnWriteArraySet<>();
        for (int i = 1; i <10 ; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }
}
