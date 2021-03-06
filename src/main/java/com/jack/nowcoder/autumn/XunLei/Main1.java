package com.jack.nowcoder.autumn.XunLei;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/9/12 18:50
 * 题目描述：
 * 有红黑两种颜色的方块积木，红色代表正数A，黑色代表负数B。
 * 选出17块积木排成一排，使得任意相邻7块积木之和都小于0。
 * 如何挑选才能使17块积木之和最大，最大值是多少？
 * 输入
 * 正数A，负数B
 * A和B绝对值小于10000
 * 输出
 * 积木之和的最大值
 * 样例输入
 * 10 -61
 * 样例输出
 * 28
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A=sc.nextInt();
        int B=sc.nextInt();
        System.out.println(findMax(A, B));
    }
    private static int findMax(int A,int B) {
        int val=Math.abs(B)/A;
        int m=17/(val+1);
        int n=17%(val+1);
        return val*A*m+m*B+A*n;
    }
}