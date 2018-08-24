package com.jack.demo.ThreadLocalDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Jack on 8/23/2018 1:17 PM
 */
public class ThreadLocalDemo1 {
    public static void main(String[] args) {
        //SimpleDateFormat被多线程访问
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i=0;i<1000;i++) {
            executorService.execute(new ParseDate(i));
        }
    }
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static class ParseDate implements Runnable{
        int i=0;
        public ParseDate(int i) {
            this.i=i;
        }
        @Override
        public void run() {
            try {
                Date date = sdf.parse("2015-03-29 16:26:"+i%60);
                System.out.println(i+":"+date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
