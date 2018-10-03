package com.jack.algorithm.概览.多线程;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangta on 1/4/2018.
 * 通常情况下使用synchronized加锁
 * 当需要时间锁等候、可中断锁等候、无块结构锁、多个条件变量或者锁投票时，使用ReentrantLock
 * Lock接口有3个实现它的类：
 * ReentrantLock,即重入锁
 * ReetrantReadWriteLock.ReadLock,即读锁
 * ReetrantReadWriteLock.WriteLock,即写锁
 * lock必须被显式地创建、锁定和释放，为了可以使用更多的功能，一般用ReentrantLock为其实例化
 */
public class nonFairAndFairLock {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final ReentrantLock fairLock = new ReentrantLock(true);
    private int n;
    public static void main(String[] args) {
        nonFairAndFairLock rlt = new nonFairAndFairLock();
        for (int i = 0; i < 100; i++) {
            Thread nonT = new Thread(new NonFairTestThread(rlt));
            nonT.setName("nonFair[" + (i + 1) + "]");
            nonT.start();
            Thread fairT = new Thread(new FairTestThread(rlt));
            fairT.setName("fair[" + (i + 1) + "]");
            fairT.start();
        }
    }
    // 非公平锁
    static class NonFairTestThread implements Runnable {
        private nonFairAndFairLock rlt;

        public NonFairTestThread(nonFairAndFairLock rlt) {
            this.rlt = rlt;
        }
        public void run() {
            lock.lock();
            try {
                rlt.setNum(rlt.getNum() + 1);
                System.out.println(Thread.currentThread().getName()
                        + " nonFairLock***************" + rlt.getNum());
            } finally {
                lock.unlock();
            }
        }
    }
    // 公平锁
    static class FairTestThread implements Runnable {
        private nonFairAndFairLock rlt;

        public FairTestThread(nonFairAndFairLock rlt) {
            this.rlt = rlt;
        }
        public void run() {
            fairLock.lock();
            try {
                rlt.setNum(rlt.getNum() + 1);
                System.out.println(Thread.currentThread().getName()
                        + "   fairLock=======" + rlt.getNum() + "   "
                        + fairLock.getHoldCount() + " queuelength="
                        + fairLock.getQueueLength());
            } finally {
                fairLock.unlock();
            }
        }
    }
    public void setNum(int n) {
        this.n = n;
    }
    public int getNum() {
        return n;
    }
}
