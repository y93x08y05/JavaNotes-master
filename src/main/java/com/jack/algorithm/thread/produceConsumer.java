package com.jack.algorithm.thread;

/**
 * Created by zhangta on 1/4/2018.
 */
public class produceConsumer {
    private String name;
    private int age;
    boolean flag;//标记变量
    //生产者的功能，为student对象赋值
    public synchronized void set(String name,int age){
        if(this.flag){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.name = name;
        this.age = age;
        this.flag = true;
        this.notify();
    }
    //消费者的功能，打印student对象的内容
    public synchronized void get(){
        if(!this.flag){
            try{
                this.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(name+":::"+age);
        this.flag = false;
        this.notify();
    }
    public static void main(String[] args){
        produceConsumer s = new produceConsumer();
        Set ss = new Set(s);
        Get gs = new Get(s);
        Thread t1 = new Thread(ss,"生产者");
        Thread t2 = new Thread(gs,"消费者");
        t1.start();
        t2.start();
    }
}
//模拟生产者线程
class Set implements Runnable{
    private produceConsumer s;
    private int x = 0;
    public Set(produceConsumer s){
        this.s=s;
    }
    @Override
    public void run(){
        while(true){
            if(x%2 == 0){
                s.set("张涛",24);
            }else{
                s.set("高升",25);
            }
            x++;
        }
    }
}
//模拟消费者线程
class Get implements Runnable{
    private produceConsumer s;
    public Get(produceConsumer s){
        this.s=s;
    }
    @Override
    public void run(){
        while(true){
            s.get();
        }
    }
}
