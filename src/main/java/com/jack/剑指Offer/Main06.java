package com.jack.剑指Offer;

/**
 * Created by Jack on 7/30/2018 8:43 PM
 * 青蛙一次可以跳一个台阶或者两个台阶
 * 求青蛙跳上一个n阶台阶有多少种方法
 */
public class Main06 {
    public static void main(String[] args) {
        int target = 5;
        System.out.println(JumpStep(target));
    }
    public static int JumpStep(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int c = 0;
        for (int i=3;i<=target;i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
