package com.eric.myQueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2021-06-05
 * @description 阻塞队列
 */
public class MyArrayBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        demo4();
    }
    private static void demo1(){
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.add("eric1"));
        System.out.println(arrayBlockingQueue.add("eric2"));
        System.out.println(arrayBlockingQueue.add("eric3"));
//        System.out.println(arrayBlockingQueue.add("eric4"));
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
        System.out.println(arrayBlockingQueue.remove());
//        System.out.println(arrayBlockingQueue.remove());
    }

    /**
     * 有返回值
     */
    private static void demo2(){
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(arrayBlockingQueue.offer("eric1"));
        System.out.println(arrayBlockingQueue.offer("eric2"));
        System.out.println(arrayBlockingQueue.offer("eric3"));
        System.out.println(arrayBlockingQueue.offer("eric4"));

        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
    }

    /**
     * 阻塞等待，会一直等待
     * @throws InterruptedException
     */
    private static void demo3() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.put("eric1");
        arrayBlockingQueue.put("eric2");
        arrayBlockingQueue.put("eric3");
//        arrayBlockingQueue.put("eric4");

        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
        System.out.println(arrayBlockingQueue.take());
    }

    /**
     * 超时等待，在指定时间中添加或移除，超时再不再等待
     * @throws InterruptedException
     */
    private static void demo4() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
        arrayBlockingQueue.offer("eric1",2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("eric2",2, TimeUnit.SECONDS);
        arrayBlockingQueue.offer("eric3",2, TimeUnit.SECONDS);
//        arrayBlockingQueue.offer("eric4",2, TimeUnit.SECONDS);
//        System.out.println("阻塞了两秒后结束");
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(arrayBlockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println("阻塞了两秒后结束");
    }
}
