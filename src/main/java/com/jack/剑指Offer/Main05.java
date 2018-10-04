package com.jack.剑指Offer;

/**
 * Created by Jack on 7/30/2018 8:36 PM
 * 输入一个正数n
 * 输出斐波那契数列的第n项
 * (从0开始，第0项为0)n<=39
 */
public class Main05 {
    public static void main(String[] args) {
        int val = 6;
        System.out.println(find(val));
    }
    public static int find(int val) {
        int a = 1;
        int b = 1;
        int c = 0;
        if (val == 1 || val == 2) {
            return 1;
        }
        for (int i=3;i<=val;i++) {
            c = a + b;
            b = a;
            a = c;
        }
        return c;
    }
}
