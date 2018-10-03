package com.jack.algorithm.概览.并发包;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zhangta on 1/8/2018.
 * 阻塞栈，先进后出
 */
public class concurrentBlockingDeque1 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> bDeque = new LinkedBlockingDeque<>(20);
        for (int i = 0; i < 30; i++) {
            //将指定元素添加到此阻塞栈中
            bDeque.putFirst("" + i);
            System.out.println("向阻塞栈中添加了元素:" + i);
        }
        System.out.println("程序到此运行结束，即将退出----");
    }
}
