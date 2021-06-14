package com.eric.myFunctionInterface;

import java.util.function.Supplier;

/**
 * @author EricRaww
 * @create 2021-06-14
 * @description 生产型接口，没有输入，只有返回值
 */
public class MySupplier {
    public static void main(String[] args) {
//        Supplier<String> supplier = new Supplier<String>() {
//            @Override
//            public String get() {
//                return "eric";
//            }
//        };
        Supplier<String> supplier =()->"eric";
        System.out.println(supplier.get());
    }
}
