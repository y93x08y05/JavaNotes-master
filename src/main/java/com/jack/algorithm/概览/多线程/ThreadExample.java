package com.jack.algorithm.概览.多线程;

/**
 * 进程是具有一定独立功能的程序，关于某个数据集合上的一次运行活动，是系统进行资源分配
 * 和调度的一个独立单位。线程是进程的一个实体，是CPU分配调度的基本单位，代码的执行体。
 * 同一个进程中可以包括多个线程，并且线程共享整个进程的资源，一个进程至少包括一个线程。
 * 线程的声明周期就是线程从出生到死亡的过程中经历的一系列状态。
 * 线程通过创建爱你Thread的一个实例new Thread()进入new新建状态；之后调用start()方法
 * 进入等待被分配时间片，进入runnable状态；之后线程获得CPU资源执行任务，进入running
 * 状态；当线程执行完毕，或被其他线程杀死，进入dead死亡状态；如果由于某种原因导致正在
 * 运行的线程让出CPU并暂停自己的执行，进入blocked堵塞状态，在多种条件下，blocked状态
 * 可以恢复成runnable状态，最终在线程重新拿到时间片后，就可以进入running状态重新运行。
 * 在running状态下，如果时间片用完了或者线程主动放弃CPU的使用，线程重新回到runnable状态。
 * 时间片指的是CPU的时间片段，CPU将它的可执行时间分为很多片段，每个片段随机分配给处在
 * runnable状态下的线程，则达到并发的效果。单核CPU，通过分割很多的时间片，每个程序都
 * 有机会运行，宏观是并发，实际是串行执行的。
 */
public class ThreadExample {
    public static void main(String [] args) {
        PrimeThread thread = new PrimeThread();
        thread.setName("Thread ");
        thread.start();
        Runnable runnable = ()-> System.out.println(Thread.currentThread().getName()+" runnable run.");
        Thread t = new Thread(runnable);
        t.run();
        System.out.println(Thread.currentThread().getName());
    }
    static class PrimeThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "Thread run");
        }
    }
}