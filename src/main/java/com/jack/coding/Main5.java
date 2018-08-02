package com.jack.coding;

/**
 * Created by Jack on 7/30/2018 8:36 PM
 * Fibonacci sequence input n and find the nst
 */
public class Main5 {
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
