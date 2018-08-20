package com.jack.algorithm.volatileKeyWord;

public class VolatileTest2 {
    public  int inc = 0;
    public synchronized void increase() {
        inc++;
    }
    public static void main(String[] args) {
        final VolatileTest2 test = new VolatileTest2();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<10;j++){
                        System.out.println(j);
                        test.increase();
                    }
                }
            }.start();
        }
        //保证前面的线程都执行完
        while(Thread.activeCount()>1)
            Thread.yield();
        System.out.println(test.inc);
    }
}