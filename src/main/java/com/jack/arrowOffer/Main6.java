package com.jack.arrowOffer;

/**
 * Created by Jack on 7/30/2018 8:43 PM
 * frog could jump one or two step in one time
 * frog jump the steps find how many method if frog jump a nst step
 */
public class Main6 {
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
