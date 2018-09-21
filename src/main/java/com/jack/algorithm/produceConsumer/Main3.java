package com.jack.algorithm.produceConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Jack on 7/30/2018 10:26 AM
 */
public class Main3 {
    private static Integer count = 0;
    final BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(5);

    public static void main(String[] args) {
        Main3 main3 = new Main3();
        new Thread(main3.new Producer()).start();
        new Thread(main3.new Consumer()).start();
        new Thread(main3.new Producer()).start();
        new Thread(main3.new Consumer()).start();
    }
    class Producer implements Runnable {
        public void run() {
            for (int i=0;i<5;i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    blockingQueue.put(1);
                    count++;
                    System.out.println("生产者：" + Thread.currentThread().getName() + "已生产,商品数量" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
                try {
                    blockingQueue.take();
                    count--;
                    System.out.println("消费者：" + Thread.currentThread().getName() + "已消费,剩余产品数量：" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
