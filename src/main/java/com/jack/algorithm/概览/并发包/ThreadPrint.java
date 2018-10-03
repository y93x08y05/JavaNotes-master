package com.jack.algorithm.概览.并发包;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrint {
    private static final Lock lock = new ReentrantLock();
    private static final Condition isA = lock.newCondition();
    private static final Condition isB = lock.newCondition();
    private static final Condition isC = lock.newCondition();
    static class ThreadA extends Thread {
        @Override
        public void run() {
            while (true){
                lock.lock();
                System.out.println("A");
                isB.signal();
                try {
                    isA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }
    static class ThreadB extends Thread {
        @Override
        public void run() {
            while (true){
                lock.lock();
                System.out.println("B");
                isC.signal();
                try {
                    isB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }
    static class ThreadC extends Thread {
        @Override
        public void run() {
            while (true){
                lock.lock();
                System.out.println("C");
                isA.signal();
                try {
                    isC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unlock();
            }
        }
    }
    public static void main(String [] args) throws InterruptedException {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        ThreadC c = new ThreadC();
        a.join();
        b.join();
        c.join();
        a.start();
        b.start();
        c.start();
    }
}