package com.jack.nowcoder.autumn.creditCardCenter.test2018;

/**
 * Created by Jack on 8/29/2018 11:29 AM
 */
public class Hello {
    public static void main(String[] args) {
        A ab = new B();
        ab.say();
        ab = new B();
        ab.say();
    }
}
class A {
    static {
        System.out.print("A");
    }
    public A() {
        System.out.print("a");
    }
    void say() {
        System.out.print("1");
    }
}
class B extends A {
    static {
        System.out.print("B");
    }
    public B() {
        System.out.print("b");
    }
    void say() {
        System.out.print("2");
    }
}
