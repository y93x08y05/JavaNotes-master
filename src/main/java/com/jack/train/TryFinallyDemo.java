package com.jack.train;

/**
 * @Author: Jack
 * @Date: 2018/11/1 16:32
 */
public class TryFinallyDemo {
    public static String output = "";
    public static void foo(int i) {
        try {
            if (i == 1) {
                throw new Exception();
            }
        } catch (Exception e) {
            output += "2";
            return;
        } finally {
            output += "3";
        }
        output += "4";
    }
    public static void main(String[] args) {
        foo(0);
        foo(1);
        System.out.println(output);
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(j);
                }
                System.out.println(" ");
            });
        }
        for (Thread thread: threads) {
            thread.start();
        }
    }
}