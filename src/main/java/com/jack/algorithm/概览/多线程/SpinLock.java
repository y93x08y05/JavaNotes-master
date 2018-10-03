package com.jack.algorithm.概览.多线程;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by zhangta on 1/4/2018.
 * Java中原子操作，CAS(compare and set)
 */
public class SpinLock {
    AtomicReference<Thread> owner = new AtomicReference<Thread>();
    private int count;
    public void lock() {
        Thread cur = Thread.currentThread();
        /**
         * lock函数将owner设置为当前线程，并且预测原来的值为空
         * unlock函数将owner设置为null，并且预测值为当前线程
         * 当有第二个线程调用lock操作时由于owner值不为空，导致循环一直被执行
         * 直至第一个线程调用unlock函数将owner设置为null，第二个线程才能进入临界区
         */
        while (!owner.compareAndSet(null, cur)){
        }
    }
    public void unLock() {
        Thread cur = Thread.currentThread();
        owner.compareAndSet(cur, null);
    }
}
 class Test implements Runnable {
    static int sum;
    private SpinLock lock;
    public Test(SpinLock lock) {
        this.lock = lock;
    }
    public static void main(String[] args) throws InterruptedException {
        SpinLock lock = new SpinLock();
        for (int i = 0; i < 100; i++) {
            Test test = new Test(lock);
            Thread t = new Thread(test);
            t.start();
        }
        Thread.currentThread().sleep(1000);
        System.out.println(sum);
    }
    @Override
    public void run() {
        this.lock.lock();
        sum++;
        this.lock.unLock();
    }
}
