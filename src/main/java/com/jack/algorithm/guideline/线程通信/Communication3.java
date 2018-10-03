package com.jack.algorithm.guideline.线程通信;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2018/10/3 11:26
 */
public class Communication3 {
    private static List<String> list=new ArrayList<>();
    public static void add() {
        list.add("anyString");
    }
    public static int size() {
        return list.size();
    }
    static class ThreadA extends Thread {
        private Object lock;
        public ThreadA(Object lock) {
            super();
            this.lock=lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                if (Communication3.size()!=5) {
                    System.out.println("wait begin "+System.currentTimeMillis());
                    try {
                        lock.wait();
                        System.out.println("wait end "+System.currentTimeMillis());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    static class ThreadB extends Thread {
        private Object lock;
        public ThreadB(Object lock) {
            super();
            this.lock=lock;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (int i=0;i<10;i++) {
                    Communication3.add();
                    if (Communication3.size()==5) {
                        lock.notify();
                        System.out.println("已经发出通知");
                    }
                    System.out.println("添加了"+(i+1)+"个元素");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}