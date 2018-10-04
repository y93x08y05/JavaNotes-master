package com.jack.algorithm.并发应用.cyclicbarrier;

import java.util.concurrent.*;

/**
 * Created by Jack on 7/27/2018 1:19 PM
 * Comparison of CountDownLatch and CyclicBarrier
 * 1. CountDownLatch is a wait between 多线程 group, one or more 多线程 execute after N
 * 多线程 has completed something. CyclicBarrier is a wait within 多线程 group, each 多线程
 * waits for each other, they are executed in turn after N 多线程 are intercepted.
 * 2. CountDownLatch is counting down method, CyclicBarrier is counting add method.
 * 3. CountDownLatch counting can not be reset if counting down to 0, CyclicBarrier counting
 * can be reset if counting reaches the initial value.
 * 4. CountDownLatch can not reused, CyclicBarrier can reused.
 */
public class CyclicBarrierDemo {
    private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4,10,60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
    private static final CyclicBarrier cb = new CyclicBarrier(4, new Runnable() {
        public void run() {
            System.out.println("four boys go to playground");
        }
    });
    private static class GoThread extends Thread {
        private final String name;
        public GoThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " starting go");
            try {
                Thread.sleep(1000);
                cb.await();
                System.out.println(name + " go from building");
                Thread.sleep(1000);
                System.out.println(name + " has arrived at playground");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        String [] s = {"Denny","John","Mary","Thomas"};
        for (int i=0;i<4;i++) {
            threadPool.execute(new GoThread(s[i]));
        }
        try {
            Thread.sleep(4000);
            System.out.println("all of us have arrived at playground,and then play football");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
