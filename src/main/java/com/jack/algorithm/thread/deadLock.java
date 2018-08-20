package com.jack.algorithm.thread;

/**
 * Created by zhangta on 1/8/2018.
 * 线程A有互斥锁lock1，线程B有互斥锁lock2
 * 线程A持有lock1时想获取lock2，线程B持有lock2时想获取lock1
 * 线程A阻塞等待lock2释放，线程B阻塞等待lock1释放
 * 二者互相等待，却都未释放，则为死锁
 * 避免死锁：
 * 1、只在必要的最短时间内持有锁，同步语句块代替同步方法
 * 2、编写不在同一时刻需要持多个锁的代码，不可避免时则尽量让第二个锁时间短
 * 3、创建使用大锁代替多个小锁并用于互斥，不作为单个对象的对象级别锁
 */
public class deadLock extends Object{
    private String objID;
    public deadLock(String id) {
        objID = id;
    }
    public synchronized void checkOther(deadLock other) {
        print("entering checkOther()");
        try { Thread.sleep(2000); }
        catch ( InterruptedException x ) { }
        print("in checkOther() - about to " + "invoke 'Other1.action()'");
        //调用other对象的action方法，由于该方法是同步方法，因此会试图获取other对象的对象锁
        other.action();
        print("leaving checkOther()");
    }
    public synchronized void action() {
        print("entering action()");
        try { Thread.sleep(500); }
        catch ( InterruptedException x ) { }
        print("leaving action()");
    }
    public void print(String msg) {
        threadPrint("objID=" + objID + " - " + msg);
    }
    public static void threadPrint(String msg) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + msg);
    }
    public static void main(String[] args) {
        final deadLock obj1 = new deadLock("obj1");
        final deadLock obj2 = new deadLock("obj2");

        Runnable runA = new Runnable() {
            public void run() {
                obj1.checkOther(obj2);
            }
        };
        Thread threadA = new Thread(runA, "threadA");
        threadA.start();
        try { Thread.sleep(200); }
        catch ( InterruptedException x ) { }
        Runnable runB = new Runnable() {
            public void run() {
                obj2.checkOther(obj1);
            }
        };
        Thread threadB = new Thread(runB, "threadB");
        threadB.start();
        try { Thread.sleep(5000); }
        catch ( InterruptedException x ) { }

        threadPrint("finished sleeping");

        threadPrint("about to interrupt() threadA");
        threadA.interrupt();
        try { Thread.sleep(1000); }
        catch ( InterruptedException x ) { }

        threadPrint("about to interrupt() threadB");
        threadB.interrupt();
        try { Thread.sleep(1000); }
        catch ( InterruptedException x ) { }
    }
}
