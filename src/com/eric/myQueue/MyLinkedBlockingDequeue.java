package com.eric.myQueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author EricRaww
 * @create 2021-06-06
 * @description 双端队列
 */
public class MyLinkedBlockingDequeue {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();
        linkedBlockingDeque.offer("eric");
        linkedBlockingDeque.offerFirst("eric-first");
        linkedBlockingDeque.offerLast("eric-last");
        while (!linkedBlockingDeque.isEmpty()){
            System.out.println(linkedBlockingDeque.poll());
        }
    }
}
