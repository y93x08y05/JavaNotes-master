package com.jack.algorithm.概览.并发包;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhangta on 1/8/2018.
 * 阻塞队列的接口是java.util.并发包.BlockingQueue，先进先出
 * 多个实现类：
 * ArrayBlockingQueue、
 * DelayQueue、
 * LinkedBlockingQueue、
 * PriorityBlockingQueue、
 * SynchronousQueue等
 * 有界队列当队列满时阻塞等待，有元素出队，后续元素才会加入
 */
public class concurrentBlockingQueue1 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bqueue = new ArrayBlockingQueue<String>(20);
        for (int i = 0; i < 30; i++) {
            //将指定元素添加到此队列中
            bqueue.put("加入元素" + i);
            System.out.println("向阻塞队列中添加了元素:" + i);
        }
        System.out.println("程序到此运行结束，即将退出----");
    }
}
