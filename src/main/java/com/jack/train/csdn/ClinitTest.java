package com.jack.train.csdn;

/**
 * @Author: Jack
 * @Date: 2018/9/14 8:42
 */
public class ClinitTest {
    public static void main(String[] args) {
        System.out.println(Child1.b);
    }
}
class Father1 {
    public static int a = 1;
    static  {
        a = 2;
    }
}
class Child1 extends Father1 {
    public static int b = a;
}