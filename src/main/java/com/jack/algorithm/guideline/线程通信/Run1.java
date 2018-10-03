package com.jack.algorithm.guideline.线程通信;

/**
 * @Author: Jack
 * @Date: 2018/10/3 10:59
 * 通过synchronized关键字实现线程间的通信
 * 共享内存的通信方式，由于线程A和线程B持有同一个Communication类的对象
 * 尽管两个线程需要调用不同的方法，但是是同步执行的。
 * 线程B必须等待线程A执行完了之后再执行，即实现了通信。
 * 多个需要访问同一个共享变量，谁获得了访问权限，谁就可以执行。
 */
public class Run1 {
    public static void main(String[] args) {
        Communication1 comm=new Communication1();
        Communication1.ThreadA a=new Communication1.ThreadA(comm);
        Communication1.ThreadB b=new Communication1.ThreadB(comm);
        a.start();
        b.start();
    }
}