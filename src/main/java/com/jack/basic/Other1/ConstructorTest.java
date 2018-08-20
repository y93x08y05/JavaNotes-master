package com.jack.basic.Other1;

/**
 * 子类构造方法在调用时必须先调用父类的，如果父类的没有无参构造，
 * 必须在子类中显示调用，使用super
 */
public class ConstructorTest extends Base{
    public ConstructorTest(String s) {
        super(s);
        System.out.println("D");
    }
    public static void main(String [] args) {
        new ConstructorTest("C");
    }
}
class Base {
    public Base(String s) {
        System.out.println("B");
    }
}