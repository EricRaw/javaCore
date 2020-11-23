package com.eric.myconcurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author EricRaww
 * @create 2020-11-12
 */
public class MyAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        System.out.println(atomicInteger);
        int i = atomicInteger.addAndGet(1);
        System.out.println(i);
        System.out.println(atomicInteger);
    }
}
