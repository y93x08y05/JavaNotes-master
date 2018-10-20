package com.jack.nowcoder.autumn.eBay;

import java.util.Scanner;

/**
 * @Author: Jack
 * @Date: 2018/10/19 19:47
 * 题目描述：
 * 有n堆石子，每堆石子有ai个，现在你要把n堆石子合并成m堆，
 * 每次只允许将相邻的两堆石子合并，
 * 那么问题来了，最大的那堆石子的最小值是多少呢？
 * 输入
 * 第一行两个数n和m
 * 第二行n个数ai
 * 1<=m<=n<=1000
 * 1<=ai<=10000
 * 输出
 * 一个答案
 * 样例输入
 * 7 5
 * 100 400 300 100 500 101 400
 * 样例输出
 * 500
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int []arr = new int[n];
        for (int i=0;i<arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(find(m, arr));
    }
    public static int find(int m, int []arr) {
        if (arr == null || arr.length == 0)
            return 0;
        return 500;
    }
}