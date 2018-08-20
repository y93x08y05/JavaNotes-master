package com.jack.nowcoder.spring.A163.SpringJava0617;

public class P1 {
    static int a;
    int b;
    static int c;
    public int aMethod() {
        a++;
        return a;
    }
    public int bMethod() {
        b++;
        return b;
    }
    public static int cMethod() {
        c++;
        return c;
    }
    public static void main(String args[]) {
        P1 test1 = new P1();
        test1.aMethod();
        System.out.println(test1.aMethod());
        P1 test2 = new P1();
        test2.bMethod();
        System.out.println(test2.bMethod());
        P1 test3 = new P1();
        test3.cMethod();
        System.out.println(test3.cMethod());
    }
}