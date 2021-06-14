package com.eric.myFunctionInterface;

import java.util.function.Consumer;

/**
 * @author EricRaww
 * @create 2021-06-14
 * @description 消费型接口，只有输入，没有返回值
 */
public class MyConsumer {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };
        Consumer<String> consumer=(s)-> System.out.println(s);
        consumer.accept("eric");
    }
}
