package com.jack.algorithm.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zhangta on 1/4/2018.
 * 模拟产生16个日志对象，16秒打印完
 * 增加四个线程调用parseLog方法，4秒打印完
 */
public class multiThread {
    public static void main(String[] args){
        //定义线程共享的队列容器，数据从队列一端输入一端输出
        final BlockingQueue<String> queue=new ArrayBlockingQueue<String>(16);
        for(int i=0;i<4;i++){
            new Thread(new Runnable(){
                @Override
                public void run(){
                    while(true){
                        try{
                            parseLog(queue.take());
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        for(int i=0;i<16;i++){
            final String log=""+(i+1);
            {
                try{
                    queue.put(log);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void parseLog(String log){
        System.out.println(log+":"+(System.currentTimeMillis()/1000));
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
