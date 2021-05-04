package com.eric.myThreadLocal;

/**
 * @author EricRaww
 * @create 2021-05-03
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Integer> count = new ThreadLocal<>();
        count.set(10);
        Integer integer = count.get();
        System.out.println(integer);
        /**
         * 使用完ThreadLocal后，需要remove(),避免内存泄露
         */
        count.remove();
        Integer integer1 = count.get();
        System.out.println(integer1);

    }
}
