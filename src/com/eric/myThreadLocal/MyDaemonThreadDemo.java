package com.eric.myThreadLocal;

/**
 * @author EricRaww
 * @create 2021-05-07
 * @description
 */
public class MyDaemonThreadDemo {
    public static void main(String[] args) {
        God god = new God();
        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();
       new Thread(new You()).start();

    }
}
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你的一生都按自己的意愿生活");
        }
        System.out.println("GoodBye");
    }
}
class God implements Runnable{

    @Override
    public void run() {
        for (; ;) {
            System.out.println("god is always");
        }
    }
}
