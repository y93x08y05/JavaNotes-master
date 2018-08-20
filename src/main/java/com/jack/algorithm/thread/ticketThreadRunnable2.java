package com.jack.algorithm.thread;

/**
 * Created by zhangta on 1/8/2018.
 * Runnable接口比Thread类有如下优势：
 *避免由于Java的单继承特性而带来的局限
 * 增强程序的健壮性，代码能够被多个线程共享，代码与数据是独立的
 * 适合多个相同程序代码的线程区处理同一资源的情况
 * 3个Thread对象共同执行一个Runnable对象中的代码。非线程安全，可加同步互斥锁
 * 如果new了三个Runnable对象，则跟ticketThreadRunnable1的执行结果相同
 */
public class ticketThreadRunnable2 {
    public static void main(String[] args){
        MyThread2 my = new MyThread2();
        new Thread(my).start();
        new Thread(my).start();
        new Thread(my).start();
    }
}
class MyThread2 implements Runnable{
    private int ticket = 5;
    public void run(){
        for (int i=0;i<10;i++)
        {
            if(ticket > 0){
                System.out.println("ticket = " + ticket--);
            }
        }
    }
}