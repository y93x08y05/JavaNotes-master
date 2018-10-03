package com.jack.algorithm.概览.多线程;

/**
 * Created by zhangta on 1/4/2018.
 * 四个线程，两个线程对变量加1，另两个对变量减1
 */
public class doubleThreadAddSub {
    private int i=0;
    public static void main(String[] args){
        doubleThreadAddSub demo = new doubleThreadAddSub();
        Add add = demo.new Add();
        Sub sub = demo.new Sub();
        for(int i=1;i<=2;i++){
            new Thread(add,"线程"+i).start();
            new Thread(sub,"线程"+i).start();
        }
    }
    class Add implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                addOne();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    class Sub implements Runnable{
        @Override
        public void run(){
            for(int i=0;i<10;i++){
                subOne();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public synchronized void addOne(){
        i++;
        System.out.println(Thread.currentThread().getName()+"加1的值为"+i);
    }
    public synchronized void subOne(){
        i--;
        System.out.println(Thread.currentThread().getName()+"减1的值为"+i);
    }
}
