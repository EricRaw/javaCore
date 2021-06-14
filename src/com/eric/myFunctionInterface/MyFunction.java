package com.eric.myFunctionInterface;

import java.util.function.Function;

/**
 * @author EricRaww
 * @create 2021-06-13
 * @description Function函数型接口，输入一个参数，返回一个参数
 */
public class MyFunction {
    public static void main(String[] args) {
//        Function function= new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return Integer.parseInt(s.trim());
//            }
//        };
        Function<String,Integer> function=(s)->Integer.parseInt(s.trim());
        System.out.println(function.apply("    123"));
    }
}
