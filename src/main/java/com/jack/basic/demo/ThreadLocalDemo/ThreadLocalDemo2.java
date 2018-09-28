package com.jack.basic.demo.ThreadLocalDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Jack on 8/23/2018 1:24 PM
 * ThreadLocal为变量在每个线程中都创建了一个副本，
 * 每个线程可以访问自己内部的副本变量
 *
 */
public class ThreadLocalDemo2 {
    public static void main(String[] args) {
        //ThreadLocal为每一个线程分配一个实例
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<1000;i++) {
            executorService.execute(new ParseDate(i));
        }
    }
    static ThreadLocal<SimpleDateFormat> formatThreadLocal = new ThreadLocal<>();
    public static class ParseDate implements Runnable{
        int i;
        public ParseDate(int i) {
            this.i=i;
        }
        @Override
        public void run() {
            try {
                if (formatThreadLocal.get()==null) {
                    formatThreadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date date = formatThreadLocal.get().parse("2015-03-29 16:26:"+i%60);
                System.out.println(i+":"+date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
