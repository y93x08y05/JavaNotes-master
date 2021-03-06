package com.jack.algorithm.并发应用.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Jack on 7/27/2018 11:49 AM
 * CountDownLatch enables a 多线程 to continue executing after waiting for another 多线程 to
 * complete its work,using counter to implement.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(2) {
            @Override
            public void await() throws InterruptedException {
                super.await();
                System.out.println(Thread.currentThread().getName() + " count down is ok");
            }
        };
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is done");
            countDownLatch.countDown();
        },"thread1");
        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " is done");
            countDownLatch.countDown();
        },"thread2");
        thread1.start();
        thread2.start();
        countDownLatch.await();
    }
}
