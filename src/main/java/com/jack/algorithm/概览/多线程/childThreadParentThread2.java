package com.jack.algorithm.概览.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangta on 1/4/2018.
 */
public class childThreadParentThread2 {
    private boolean flag = false;
    Lock lock=new ReentrantLock();
    Condition con=lock.newCondition();
    public void sub(){
        lock.lock();
        try{
            while(flag){
                try{
                    con.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            for(int i=0;i<10;i++){
                System.out.println("sub"+i);
            }
            flag=true;
            con.signal();
        }finally{
            lock.unlock();
        }

    }
    public synchronized void main(){
        lock.lock();
        try{
            while(!flag){
                try{
                    con.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            for(int i=0;i<20;i++){
                System.out.println("sub"+i);
            }
            flag=false;
            con.signal();
        }finally{
            lock.unlock();
        }
    }
    public static void main(String [] args){
        final childThreadParentThread2 f=new childThreadParentThread2();
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
