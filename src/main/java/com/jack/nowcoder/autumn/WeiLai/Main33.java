package com.jack.nowcoder.autumn.WeiLai;

/**
 * @Author: Jack
 * @Date: 2018/9/11 21:19
 */
public class Main33 extends Thread{
    private int x=2;
    public static void main(String[] args) {
        new Main33().makeso();
    }
    public Main33(){
        x=5;
        start();
    }
    public void makeso(){
        try {
            join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x=x-1;
        System.out.println(x);
    }

    @Override
    public void run() {
        x*=2;
    }
}