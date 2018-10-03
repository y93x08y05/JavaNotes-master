package com.jack.algorithm.guideline.线程通信;

/**
 * @Author: Jack
 * @Date: 2018/10/3 10:34
 */
public class Communication1 {
    synchronized public void methodA() {
        System.out.println("methodA");
    }
    synchronized public void methodB() {
        System.out.println("methodB");
    }
    public static class ThreadA extends Thread {
        private Communication1 obj;

        public ThreadA(Communication1 comm) {
            this.obj=comm;
        }

        @Override
        public void run() {
            super.run();
            obj.methodA();
        }
    }
    public static class ThreadB extends Thread {
        private Communication1 obj;

        public ThreadB(Communication1 comm) {
            this.obj=comm;
        }

        @Override
        public void run() {
            super.run();
            obj.methodB();
        }
    }
}