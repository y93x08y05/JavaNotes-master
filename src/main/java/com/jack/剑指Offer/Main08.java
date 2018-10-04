package com.jack.剑指Offer;

/**
 * Created by Jack on 7/30/2018 8:53 PM
 * 2*1矩形去覆盖一个2*n更大的矩形
 * 计算有多少种方法覆盖这个矩形
 */
public class Main08 {
    public static void main(String[] args) {
        int target = 4;
        System.out.println(cover(target));
    }
    public static int cover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return cover(target-1) + cover(target-2);
    }
}
