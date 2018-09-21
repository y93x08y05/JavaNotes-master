package com.jack.algorithm.produceConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Jack on 7/30/2018 10:16 AM
 */
public class Main2 {
    private static Integer count = 0;
    private final Integer FULL = 5;
    final Lock lock = new ReentrantLock();
    final Condition put = lock.newCondition();
    final Condition get = lock.newCondition();

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        new Thread(main2.new Producer()).start();
        new Thread(main2.new Consumer()).start();
        new Thread(main2.new Producer()).start();
        new Thread(main2.new Consumer()).start();
    }
    class Producer implements Runnable {
        public void run() {
            for (int i=0;i<5;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == FULL) {
                        try {
                            put.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("生产者：" + Thread.currentThread().getName() + "已生产,商品数量" + count);
                    get.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
    class Consumer implements Runnable {
        public void run() {
            for (int i=0;i<5;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                try {
                    while (count == 0) {
                        try {
                            get.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println("消费者：" + Thread.currentThread().getName() + "已消费,剩余产品数量：" + count);
                    put.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
