package com.jack.algorithm.OOMGC;

/**
 * 任何一个对象的finalize方法只会被系统自动调用一次
 * 如果对象面临下一次回收，则finalize方法将不会再次执行
 */
public class GC1 {
    public static GC1 SAVE_HOOK = null;
    public void isAlive (){
        System.out.println("Yes I'm still alive");
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        GC1.SAVE_HOOK = this;
    }
    public static void main (String [] args) throws Throwable{
        SAVE_HOOK = new GC1();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //finalize方法优先级低，暂停5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no , i am dead");
        }
        //自救失败
        SAVE_HOOK = null;
        System.gc();
        //finalize方法优先级低，暂停5秒等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no ,i am dead");
        }
    }
}