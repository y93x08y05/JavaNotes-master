package com.jack.algorithm.概览.多线程;

/**
 * Created by zhangta on 1/4/2018.
 * 子线程循环10次，主线程循环20次，重复循环50次
 */
public class childThreadParentThread1 {
    private boolean flag = false;
    public synchronized void sub(){
        while(flag){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        for(int i=0;i<10;i++){
            System.out.println("sub"+i);
        }
    }
    public synchronized void main(){
        while(!flag){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        for(int i=0;i<20;i++){
            System.out.println("main"+i);
        }
        flag=false;
        this.notify();
    }
    public static void main(String [] args){
        final childThreadParentThread1 f=new childThreadParentThread1();
        new Thread(
                new Runnable(){
                    @Override
                    public void run(){
                        for(int i=0;i<50;i++){
                            f.sub();
                        }
                    }
                }
        ).start();
        for(int i=0;i<50;i++){
            f.main();
        }
    }
}
