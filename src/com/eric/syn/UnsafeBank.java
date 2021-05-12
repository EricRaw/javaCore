package com.eric.syn;

import java.math.BigDecimal;

/**
 * @author EricRaww
 * @create 2021-05-10
 * @description
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(new BigDecimal("100"), "结婚基金");
        Drawing you = new Drawing(account, new BigDecimal("60"), new BigDecimal("0"));
        Drawing yourWife = new Drawing(account, new BigDecimal("80"), new BigDecimal("0"));
        new Thread(yourWife,"你老婆").start();
        new Thread(you,"你").start();


    }
}
class Account{
    BigDecimal money;
    String name;

    public Account(BigDecimal money, String name) {
        this.money = money;
        this.name = name;
    }
}
class Drawing implements Runnable{
    Account account;
    /**
     * 取了多少钱
     */
    BigDecimal drawingMoney;
    /**
     * 现在手里有多少钱
     */
    BigDecimal nowMoney;

    public Drawing(Account account, BigDecimal drawingMoney, BigDecimal nowMoney) {
        this.account = account;
        this.drawingMoney = drawingMoney;
        this.nowMoney = nowMoney;
    }


    @Override
    public  void run() {
        synchronized (account) {
            int i = account.money.compareTo(drawingMoney);
            if (i==-1){
                System.out.println(Thread.currentThread().getName()+"钱不够了，取不了");
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.money=account.money.subtract(drawingMoney);
            nowMoney=account.money.add(nowMoney);
            System.out.println(account.name+"余额为："+account.money);
            System.out.println(Thread.currentThread().getName()+"手里的钱： "+nowMoney);
        }

    }
}

