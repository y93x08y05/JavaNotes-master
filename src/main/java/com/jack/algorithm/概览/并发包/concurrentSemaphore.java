package com.jack.algorithm.概览.并发包;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量(semaphore)控制进程之间的协作
 * 通过对信号量的操作实现进程之间的互斥和同步，也可用于多线程控制
 * semaphore即计数信号量，控制一定资源的消费与回收
 * 控制某个资源被同时访问的任务数，通过acquire()获取许可，通过release()释放许可
 * 如同时访问任务数满，则其他acquire等待有任务被release之后才能得到许可
 */
public class concurrentSemaphore {
    public static void main(String[] args) {
        //采用新特性来启动和管理线程——内部使用线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //只允许5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        //模拟10个客户端访问
        for (int index = 0; index < 10; index++){
            final int num = index;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        //获取许可
                        semp.acquire();
                        System.out.println("线程" +
                                Thread.currentThread().getName() + "获得许可："  + num);
                        //模拟耗时的任务
                        for (int i = 0; i < 999999; i++) ;
                        //释放许可
                        semp.release();
                        System.out.println("线程" +
                                Thread.currentThread().getName() + "释放许可："  + num);
                        System.out.println("当前允许进入的任务个数：" +
                                semp.availablePermits());
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        }
        //关闭线程池
        exec.shutdown();
    }
}
