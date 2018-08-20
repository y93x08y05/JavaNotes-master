package com.jack.algorithm.concurrent;

/**
 * 不能解决ABA问题，通过一个Boolean值来标记是否修改成功
 */

import java.util.concurrent.atomic.AtomicMarkableReference;

public class AtomicMarkableReferenceTest {
    public final static AtomicMarkableReference<String> ATOMIC_MARKABLE_REFERENCE = new AtomicMarkableReference<String>("abc",false);
    public static void main(String [] args){
        System.out.println("mark:" + ATOMIC_MARKABLE_REFERENCE.isMarked());
        boolean thread1 = ATOMIC_MARKABLE_REFERENCE.isMarked();
        System.out.println("mark:" + ATOMIC_MARKABLE_REFERENCE.isMarked());
        boolean thread2 = ATOMIC_MARKABLE_REFERENCE.isMarked();
        //线程1更改abc为abc2
        System.out.println("change result:" + ATOMIC_MARKABLE_REFERENCE.compareAndSet("abc","abc2",thread1,!thread1));
        //线程2获取到mark值为true，原始值为abc2
        System.out.println("mark:" + ATOMIC_MARKABLE_REFERENCE.isMarked());
        boolean thread3 = ATOMIC_MARKABLE_REFERENCE.isMarked();
        //线程2更改abc2为abc
        System.out.println("change result:" + ATOMIC_MARKABLE_REFERENCE.compareAndSet("abc2","abc",thread2,!thread2));
        //线程3更改abc为abc2
        System.out.println("change result:" + ATOMIC_MARKABLE_REFERENCE.compareAndSet("abc","abc2",thread3,!thread3));
    }
}