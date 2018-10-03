package com.jack.algorithm.概览.线程通信;

/**
 * @Author: Jack
 * @Date: 2018/10/3 11:33
 * 线程A等待条件满足时再执行操作，线程B则向list中添加元素，改变大小
 * 当条件不满足时，线程A调用wait方法放弃CPU，并且进入阻塞状态。
 * 当条件满足时，线程B调用notify通知线程A，让其进入可运行状态。
 * 提高了CPU的利用率
 */
public class Run3 {
    public static void main(String[] args) {
        try {
            Object lock=new Object();
            Communication3.ThreadA a=new Communication3.ThreadA(lock);
            a.start();
            Thread.sleep(50);
            Communication3.ThreadB b=new Communication3.ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}