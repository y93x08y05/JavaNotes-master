package com.jack.algorithm.概览.线程通信;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack
 * @Date: 2018/10/3 11:02
 */
public class Communication2 {
    private static List<String> list=new ArrayList<>();
    public void add() {
        list.add("elements");
    }
    public int size() {
        return list.size();
    }
    static class ThreadA extends Thread {
        private Communication2 comm;
        public ThreadA(Communication2 comm) {
            super();
            this.comm=comm;
        }

        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                list.add(""+i);
                System.out.println("添加了"+(i+1)+"个元素");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    static class ThreadB extends Thread {
        private Communication2 comm;
        public ThreadB(Communication2 comm) {
            super();
            this.comm=comm;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(list.size()+"是多少");
                    if (list.size()==5) {
                        System.out.println("==5，线程B准备退出了");
                        throw new InterruptedException();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}