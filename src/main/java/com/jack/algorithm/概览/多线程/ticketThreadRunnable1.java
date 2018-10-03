package com.jack.algorithm.概览.多线程;

/**
 * Created by zhangta on 1/8/2018.
 * 三个Thread对象，三个线程分别执行三个对象中的代码，即三个线程独立完成卖票
 */
public class ticketThreadRunnable1 {
    public static void main(String[] args){
        new MyThread1().start();
        new MyThread1().start();
        new MyThread1().start();
    }
}
class MyThread1 extends Thread{
    private int ticket = 5;
    public  void run(){
        for (int i=0;i<10;i++)
        {
            if(ticket > 0){
                 System.out.println("ticket = " + ticket--);
            }
        }
    }
}
