package com.eric.myQueue;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author EricRaww
 * @create 2021-06-06
 * @description 延迟队列
 */
public class MyDelayQueue {
    private static DelayQueue delayQueue=new DelayQueue();

    public static void main(String[] args) {
        producer();
        consumer();

    }
    public static void producer(){
        delayQueue.put(new MyDelay(1000,"我的消息1"));
        delayQueue.put(new MyDelay(3000,"我的消息2"));
    }
    public static void consumer(){
        System.out.println("start at"+ DateFormat.getDateTimeInstance().format(new Date()));
        while (!delayQueue.isEmpty()){
            try {
                System.out.println(delayQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("stop at"+DateFormat.getDateTimeInstance().format(new Date()));
    }
    static class MyDelay implements Delayed{
        long delayTime=System.currentTimeMillis();
        private String message;

        public MyDelay(long delayTime, String message) {
            this.delayTime = this.delayTime+delayTime;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "MyDelay{" +
                    "message='" + message + '\'' +
                    '}';
        }

        /**
         * 获取剩余时间
         * @param unit
         * @return
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayTime-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        /**
         * 队列里元素的排序依据
         * @param o
         * @return
         */
        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
