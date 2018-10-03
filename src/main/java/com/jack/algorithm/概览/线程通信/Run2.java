package com.jack.algorithm.概览.线程通信;

/**
 * @Author: Jack
 * @Date: 2018/10/3 11:09
 * 通过while轮询的方式进行通信，线程A在不断的改变条件，然后线程B
 * 不停地通过while语句检测条件是否成立，从而实现线程间的通信，
 * 但是比较浪费CPU资源，JVM调度器将CPU交给线程B执行时，不断地
 * 测试某个条件是否成立，
 */
public class Run2 {
    public static void main(String[] args) {
        Communication2 comm=new Communication2();
        Communication2.ThreadA a=new Communication2.ThreadA(comm);
        a.setName("A");
        a.start();
        Communication2.ThreadB b=new Communication2.ThreadB(comm);
        b.setName("B");
        b.start();
    }
}