package com.jack.leetcode;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/11 15:59
 * LeetCode 70
 * 假设你正在爬楼梯。需要n个台阶才能到达楼顶。
 * 每次你可以爬1或者2个台阶，你有多少种不同的方法可以爬到楼顶呢？
 * 给定n是一个正整数。
 * 例1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 例2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(climbStairs(n));
    }
    private static int climbStairs(int n) {
        if (n==1)
            return 1;
        if (n==2)
            return 2;
        int a=1;
        int b=2;
        int c=0;
        for (int i=3;i<=n;i++) {
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}