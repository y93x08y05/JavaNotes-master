package com.jack.algorithm.produceConsumer;

/**
 * Created by Jack on 7/30/2018 9:52 AM
 */
public class Main1 {
    private static Integer count = 0;
    private final Integer FULL = 5;
    private static String lock = "lock";

    public static void main(String[] args) {
        Main1 main1 = new Main1();
        new Thread(main1.new Producer()).start();
        new Thread(main1.new Consumer()).start();
        new Thread(main1.new Producer()).start();
        new Thread(main1.new Consumer()).start();
    }
    class Producer implements Runnable {
        public void run() {
            for (int i=0;i<5;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock) {
                    while (count == FULL) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println("生产者：" + Thread.currentThread().getName() + "已生产,商品数量" + count);
                    lock.notifyAll();
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
                synchronized (lock) {
                    while (count == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    count--;
                    System.out.println("消费者：" + Thread.currentThread().getName() + "已消费,剩余产品数量：" + count);
                    lock.notify();
                }
            }
        }
    }
}
