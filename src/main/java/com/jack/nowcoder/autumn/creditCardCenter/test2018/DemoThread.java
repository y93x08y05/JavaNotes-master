package com.jack.nowcoder.autumn.creditCardCenter.test2018;

/**
 * Created by Jack on 8/29/2018 9:50 AM
 */
class DemoThread extends Thread {
    public static void main(String args[]) {
        DemoThread threadOne = new DemoThread();
        DemoThread threadTwo = new DemoThread();
        threadOne.start();
        System.out.print("thread one.");
        threadTwo.start();
        System.out.print("thread two.");
    }
    public void run() {
        System.out.print("Thread.");
    }
}
