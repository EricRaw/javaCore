package com.eric.myStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author EricRaww
 * @create 2021-06-15
 * @description
 * 1.ID必须是偶数
 * 2.年龄必须大于23岁
 * 3.用户名转为大写字母
 * 4.用户名字倒着排序
 * 5.只输出一个用户
 */
public class MyStreamDemo {
    public static void main(String[] args) {
        User user1 = new User(1, "a", 21);
        User user2 = new User(2, "b", 22);
        User user3 = new User(3, "c", 23);
        User user4 = new User(4, "d", 24);
        User user5 = new User(6, "e", 26);
        List<User> list = Arrays.asList(user1, user2, user3, user4, user5);

        list.stream().filter(u->u.getId()%2==0).
                filter(u->u.getAge()>23).
                map(u->u.getName().toUpperCase()).
                sorted((u1,u2)->u2.compareTo(u1)).
//                sorted(Comparator.comparing(User::getAge)).
                limit(1).
                forEach(System.out :: println);
    }
}
