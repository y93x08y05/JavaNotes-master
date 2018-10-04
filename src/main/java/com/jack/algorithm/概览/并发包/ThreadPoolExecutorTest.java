package com.jack.algorithm.概览.并发包;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Jack on 1/8/2018.
 * 有多个构造方法，可实现自定义的线程池
 * corePoolSize：线程池中所保存的核心线程数，包括空闲线程
 * maximumPoolSize：池中允许的最大线程数
 * keepAliveTime：线程池中的空闲线程所能持续的最长时间
 * unit：持续时间的单位
 * workQueue：任务执行前保存任务的队列，仅保存由execute方法提交的Runnable任务
 * 通过execute方法讲一个Runnable任务添加到线程池中时，按照如下顺序处理：
 * 1、如果线程池中的线程数量少于corePoolSize，即使线程池中有空闲线程，
 * 也会创建一个新的线程来执行新添加的任务。
 * 2、如果线程池中的线程数量大于等于corePoolSize，但缓冲队列workQueue未满，
 * 则将新添加的任务放到workQueue中，按照FIFO的原则依次等待执行
 * （线程池中有线程空闲出来后依次将缓冲队列中的任务交付给空闲的线程执行）。
 * 3、如果线程池中的线程数量大于等于corePoolSize，且缓冲队列workQueue已满，
 * 但线程池中的线程数量小于maximumPoolSize，则会创建新的线程来处理被添加的任务。
 * 4、如果线程池中的线程数量等于了maximumPoolSize，有4种处理方式。
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args){
        //创建等待队列
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(20);
        //线程池中保存的核心线程数为3，允许的最大线程数为5
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,50, TimeUnit.MILLISECONDS,queue);
        /**
         * param detail
         * corePoolSize：表示线程池的核心线程数，指线程池中常驻线程的数量，核心线程数会一直在
         * 线程池中存活，除非线程池停止使用被资源回收，
         * maximumPoolSize：指线程池所能容纳的最大线程数量，当活动线程数达到这个数值，后续新任务阻塞，
         * keepAliveTime：非核心线程闲置时的超时时间，超过这个时长，非核心线程被回收，
         * 当allowCoreThreadTimeOut属性设置为true，则keepAliveTime作用于核心线程。
         * threadFactory：表示线程工厂，为线程池提供创建新线程的功能，
         * workQueue：表示线程池中的任务队列，通过线程池的execute方法提交Runnable对象到队列，
         * Unit：用于指定keepAliveTime的时间单位
         * RejectExecutionHandler：参数表示当ThreadPoolExecutor关闭或者饱和，提供下边四个策略考虑是否拒绝达到的任务
         * DiscardPolicy：直接忽略提交的任务
         * AbortPolicy：忽略提交的任务，在拒绝的同时抛出异常，通知调用者拒绝执行，
         * CallerRunsPolicy：让线程池的使用者所在的线程运行提交的任务调用者
         * DiscardOlderestPolicy：忽略最早放到队列中的任务
         */
        //创建七个任务
        Runnable t1 = new MyThread();
        Runnable t2 = new MyThread();
        Runnable t3 = new MyThread();
        Runnable t4 = new MyThread();
        Runnable t5 = new MyThread();
        Runnable t6 = new MyThread();
        Runnable t7 = new MyThread();
        //每个任务会在一个线程上执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        //关闭线程池
        pool.shutdown();
    }
    static class MyThread implements Runnable{
        @Override
        public void run(){
            System.out.println(Thread.currentThread().getName() + "正在执行。。。");
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
