package com.jack.algorithm.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Jack on 1/4/2018.
 * 设置一个锁，然后休眠，另外一个线程获取这个锁时
 * 如果这个锁有人在使用的就不跳过
 */
public class multiLock {
    private final static Logger logger = LoggerFactory.getLogger(multiLock.class);
    private static final ReentrantLock lock = new ReentrantLock(true);
    private static final ReentrantLock lock1 = new ReentrantLock(true);
    // 设置一个锁，然后休眠，另外一个线程获取这个锁的时候如果这个锁有人在使用的就不跳过了
    public static void main(String[] args) throws InterruptedException {
        Test1 test1 = new Test1();
        test1.start();
        Thread.sleep(500);
        Test2 test2 = new Test2();
        test2.start();
    }
    static class Test1 extends Thread {
        public void run() {
            lock.lock();
            lock1.lock();
            for (int i=0;i<2;i++) {
                logger.info("lock1被我锁住了");
                if (i==0) {
                    lock.unlock();
                }
                if (i==1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    lock1.unlock();
                }
            }
        }
    }
    static class Test2 extends Thread {
        public void run() {
            //如果锁可用，则获取锁，并立即返回值 true。
            //如果锁不可用，则此方法将立即返回值 false。
            boolean lockBoolean = lock1.tryLock();
            if (lockBoolean) {
                logger.info(this.hashCode() + "当前锁1可以使用");
            } else {
                logger.info(this.hashCode() + "当前锁1不可以使用");
            }
            logger.info(this.hashCode() + "那我就等着吧");
            lock.lock();
            try {
                logger.info(this.hashCode() + "我得到锁了");
            }catch (Exception e) {
            }
            finally {
                lock.unlock();
            }
            lock1.lock();
            try {
                logger.info(this.hashCode() + "我得到锁了1");
            }catch (Exception e) {
            }
            finally {
                lock1.unlock();
            }
        }
    }
}
