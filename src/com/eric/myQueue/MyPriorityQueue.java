package com.eric.myQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author EricRaww
 * @create 2021-06-06
 * @description
 */
public class MyPriorityQueue {
    public static void main(String[] args) {

        PriorityQueue priorityQueue = new PriorityQueue(10, new Comparator<Tank>() {
            @Override
            public int compare(Tank o1, Tank o2) {
                return o1.getLevel() - o2.getLevel();
            }
        });
        Tank tank1 = new Tank("大型tank", 1);
        Tank tank2 = new Tank("中型tank", 2);
        Tank tank3 = new Tank("小型tank", 3);
        priorityQueue.add(tank1);
        priorityQueue.add(tank2);
        priorityQueue.add(tank3);
        while (!priorityQueue.isEmpty()){
            Tank t = (Tank)priorityQueue.poll();
            System.out.println(t.getName()+"'s level is "+t.getLevel());
        }

    }

    static class Tank{
        private String name;
        private int level;

        public Tank(String name, int level) {
            this.name = name;
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
    }
}
