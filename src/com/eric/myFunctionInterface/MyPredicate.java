package com.eric.myFunctionInterface;


import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author EricRaww
 * @create 2021-06-13
 * @description Predicate断定型接口 输入一个参数返回一个boolean值
 */
public class MyPredicate {
    public static void main(String[] args) {
//        Predicate predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String str) {
//                if (str != null && str.isEmpty()) {
//                    return true;
//                }
//                return false;
//            }
//        };
        Predicate<String> predicate=(str)->str.isEmpty();
        System.out.println(predicate.test("str"));
    }
}
