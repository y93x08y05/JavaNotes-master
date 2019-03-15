package com.jack.basic.Other2;

/**
 * Created by zhangta on 2/5/2018.
 */
public class JavaUI {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("small");
    }
    public void JavaUI() {
        synchronized (this) {
            System.out.println("hello block");
        }
    }
    public synchronized void syncMethod() {
        System.out.println("hello method");
    }
}
