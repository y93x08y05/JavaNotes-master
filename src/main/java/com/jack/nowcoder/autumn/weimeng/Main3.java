package com.jack.nowcoder.autumn.weimeng;

/**
 * @Author: Jack
 * @Date: 2018/10/9 19:02
 */
public class Main3 {
    public int j = 0;
    public static void main(String[] args) {
        Main3 o = new Main3();
        for (int i = 0; i < 5; i++) {
            Thread t1=new Jia(o);
            t1.start();
            Thread t2=new Jian(o);
            t2.start();
        }
        System.out.println(o.j);
    }
    public synchronized void jia() {
        j++;
    }
    public synchronized void jian() {
        j--;
    }
}
class Jian extends Thread {
    private Main3 a;
    Jian(Main3 a) {
        this.a = a;
    }
    @Override
    public void run() {
        for (int i=0;i<10000;i++) {
            a.jian();
        }
    }
}
class Jia extends Thread {
    private Main3 a;
    Jia(Main3 a) {
        this.a = a;
    }
    @Override
    public void run() {
        for (int i=0;i<10000;i++) {
            a.jia();
        }
    }
}