package com.jack.algorithm.概览.并发包;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by zhangta on 1/8/2018.
 */
public class concurrentBlockingDeque2 {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> bDeque = new LinkedBlockingDeque<String>(20);
        for (int i = 0; i < 30; i++) {
            //将指定元素添加到此阻塞栈中
            bDeque.putFirst("" + i);
            System.out.println("向阻塞栈中添加了元素:" + i);
            if(i > 18){
                //从阻塞栈中取出栈顶元素，并将其移出
                System.out.println("从阻塞栈中移出了元素：" + bDeque.pollFirst());
            }
        }
        while (bDeque.size() > 0){
            System.out.println(bDeque.pollFirst());
        }
        System.out.println(bDeque.size() + "程序到此运行结束，即将退出----");
    }
}
