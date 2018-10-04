package com.jack.剑指Offer;

/**
 * Created by Jack on 7/30/2018 8:50 PM
 * 变态跳台阶
 * 一个青蛙可以跳一步，两步或者n步
 * 求跳上一个n阶台阶有多少种方法
 * 每一个台阶都有两种选择，跳或者不跳
 */
public class Main07 {
    public static void main(String[] args) {
        int target = 5;
        System.out.println(getValue(target));
    }
    public static int getValue(int target) {
        return (int) Math.pow(2,target-1);
    }
}
